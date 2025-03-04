package io.github.sibmaks.spring.jfr.event.reading.core;

import io.github.sibmaks.spring.jfr.event.utils.ReflectionUtils;
import jdk.jfr.Name;
import jdk.jfr.consumer.RecordedEvent;
import lombok.SneakyThrows;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public class RecordedEventInvocationHandler<T> implements InvocationHandler {
    private final RecordedEvent event;
    private final Class<T> type;
    private final Map<String, List<Method>> recordedEventMethods;
    private final Map<Method, String> methods2Name;
    private final Map<Method, MethodHandle> defaultMethods;

    public RecordedEventInvocationHandler(
            RecordedEvent event,
            Class<T> type
    ) {
        this.event = event;
        this.type = type;
        this.recordedEventMethods = ReflectionUtils.getMethodsOverloads(event.getClass());
        this.methods2Name = new HashMap<>();
        this.defaultMethods = new HashMap<>();
    }

    @SneakyThrows
    private static MethodHandle getMethodHandle(Object proxy, Method method) {
        var lookup = MethodHandles.privateLookupIn(method.getDeclaringClass(), MethodHandles.lookup());
        var methodType = MethodType.methodType(method.getReturnType(), method.getParameterTypes());
        var handle = lookup.findSpecial(method.getDeclaringClass(), method.getName(), methodType, method.getDeclaringClass());
        return handle.bindTo(proxy);
    }

    /**
     * Вызывает default-метод интерфейса корректным способом через MethodHandles.
     */
    private Object invokeDefaultMethod(Object proxy, Method method, Object[] args) throws Throwable {
        var methodHandle = this.defaultMethods.computeIfAbsent(method, it -> getMethodHandle(proxy, method));
        return methodHandle.invokeWithArguments(args != null ? args : new Object[0]);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("toString".equals(method.getName()) && method.getParameterCount() == 0) {
            return "Proxy for " + type.getName();
        }
        if (method.isDefault()) {
            return invokeDefaultMethod(proxy, method, args);
        }
        var recordedEventMethod = ReflectionUtils.getOverload(recordedEventMethods, method);
        if (recordedEventMethod != null) {
            return recordedEventMethod.invoke(event, args);
        }
        var key = methods2Name.computeIfAbsent(method, it -> {
            var name = it.getAnnotation(Name.class);
            if(name == null) {
                return null;
            }
            return name.value();
        });
        if (key != null) {
            return event.getValue(key);
        }
        throw new IllegalArgumentException("Unknown method " + method);
    }
}
