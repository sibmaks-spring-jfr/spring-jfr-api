package io.github.sibmaks.spring.jfr.event.core;

import io.github.sibmaks.spring.jfr.event.utils.ReflectionUtils;
import jdk.jfr.consumer.RecordedEvent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public class RecordedEventProxyHandler<T> implements InvocationHandler {
    private final Map<Method, String> methods2Name;
    private final RecordedEvent event;
    private final Class<T> type;
    private final Map<String, List<Method>> existingMethods;

    public RecordedEventProxyHandler(Map<Method, String> methods2Name, RecordedEvent event, Class<T> type) {
        this.methods2Name = methods2Name;
        this.event = event;
        this.type = type;
        var methods = ReflectionUtils.getMethods(event.getClass());
        this.existingMethods = methods.stream()
                .collect(Collectors.groupingBy(Method::getName));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        var key = methods2Name.get(method);
        if (key == null) {
            if ("toString".equals(method.getName()) && method.getParameterCount() == 0) {
                return "Proxy for " + type.getName();
            }
            if (method.isDefault()) {
                return method.invoke(proxy, args);
            }
            var existingMethod = getExistingMethod(method);
            if(existingMethod != null) {
                return existingMethod.invoke(event, args);
            }
            throw new IllegalArgumentException("Unknown method " + method);
        }
        return event.getValue(key);
    }

    private Method getExistingMethod(Method method) {
        var overloads = existingMethods.get(method.getName());
        if (overloads == null) {
            return null;
        }
        var methodParameters = method.getParameters();
        return overloads.stream()
                .filter(it -> Arrays.equals(it.getParameters(), methodParameters))
                .findFirst()
                .orElse(null);
    }
}
