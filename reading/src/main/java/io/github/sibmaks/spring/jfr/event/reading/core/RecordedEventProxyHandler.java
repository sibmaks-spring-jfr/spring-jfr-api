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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public class RecordedEventProxyHandler<T> implements InvocationHandler {
    private final RecordedEvent event;
    private final Class<T> type;
    private final Map<String, List<Method>> recordedEventMethods;
    private final Map<Method, String> methods2Name;
    private final Map<Method, MethodHandle> defaultMethods;
    private final Map<Method, InvocationHandler> cachedMethods;

    public RecordedEventProxyHandler(
            RecordedEvent event,
            Class<T> type
    ) {
        this.event = event;
        this.type = type;
        this.recordedEventMethods = ReflectionUtils.getMethodsOverloads(event.getClass());
        this.methods2Name = new ConcurrentHashMap<>();
        this.defaultMethods = new ConcurrentHashMap<>();
        this.cachedMethods = new ConcurrentHashMap<>();
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
        var methodHandler = cachedMethods.get(method);
        if (methodHandler != null) {
            return methodHandler.invoke(proxy, method, args);
        }
        if ("toString".equals(method.getName()) && method.getParameterCount() == 0) {
            methodHandler = this::toStringMethodHandler;
        } else if (method.isDefault()) {
            methodHandler = this::invokeDefaultMethod;
        } else {
            var recordedEventMethod = ReflectionUtils.getOverload(recordedEventMethods, method);
            if (recordedEventMethod != null) {
                methodHandler = (_proxy, _method, _args) -> recordedEventMethod.invoke(event, _args);
            } else {
                var key = methods2Name.computeIfAbsent(method, it -> {
                    var name = it.getAnnotation(Name.class);
                    if (name == null) {
                        return null;
                    }
                    return name.value();
                });
                if (key != null) {
                    methodHandler = (_proxy, _method, _args) -> event.getValue(key);
                } else {
                    methodHandler = (_proxy, _method, _args) -> {
                        throw new IllegalArgumentException("Unknown method " + method);
                    };
                }
            }
        }
        cachedMethods.put(method, methodHandler);
        return methodHandler.invoke(proxy, method, args);
    }

    private String toStringMethodHandler(Object proxy, Method method, Object[] args) {
        return "Proxy for " + type.getName();
    }

}
