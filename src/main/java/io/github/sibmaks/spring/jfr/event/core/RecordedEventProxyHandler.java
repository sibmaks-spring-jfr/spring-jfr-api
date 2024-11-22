package io.github.sibmaks.spring.jfr.event.core;

import jdk.jfr.consumer.RecordedEvent;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author sibmaks
 * @since 0.0.9
 */
@AllArgsConstructor
public class RecordedEventProxyHandler<T> implements InvocationHandler {
    private final Map<Method, String> methods2Name;
    private final RecordedEvent event;
    private final Class<T> type;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        var key = methods2Name.get(method);
        if (key == null) {
            if ("toString".equals(method.getName()) && method.getParameterCount() == 0) {
                return "Proxy for " + type.getName();
            }
            return method.invoke(proxy, args);
        }
        return event.getValue(key);
    }
}
