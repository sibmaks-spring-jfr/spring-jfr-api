package io.github.sibmaks.spring.jfr.event.core;

import jdk.jfr.Name;
import jdk.jfr.consumer.RecordedEvent;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Converter to transform RecordedEvent into a specified type.
 *
 * @author sibmaks
 * @since 0.0.9
 */
public class RecordedEventProxyFactory {

    /**
     * Create a Proxy fo a RecordedEvent to an instance of the specified type.
     *
     * @param event the RecordedEvent to convert
     * @param type  the target class type
     * @param <T>   the type parameter
     * @return an instance of type T populated with event data
     * @throws ConversionException if the conversion fails
     */
    public <T> T create(RecordedEvent event, Class<T> type) throws ConversionException {
        if (event == null) {
            throw new IllegalArgumentException("RecordedEvent cannot be null");
        }
        if (type == null) {
            throw new IllegalArgumentException("Target type cannot be null");
        }

        var methods = type.getDeclaredMethods();
        var methods2Name = new HashMap<Method, String>();

        for (var method : methods) {
            var name = method.getAnnotation(Name.class);
            if (name == null) {
                continue;
            }
            methods2Name.put(method, name.value());
        }

        var classLoader = type.getClassLoader();
        var interfaces = getInterfaces(type).toArray(Class[]::new);

        try {
            return (T) Proxy.newProxyInstance(
                    classLoader,
                    interfaces,
                    (proxy, method, args) -> {
                        var key = methods2Name.get(method);
                        if (key == null) {
                            return method.invoke(proxy, args);
                        }
                        return event.getValue(key);
                    }
            );
        } catch (Exception e) {
            throw new ConversionException("Error converting RecordedEvent to " + type.getName(), e);
        }
    }

    private <T> Set<Class<?>> getInterfaces(Class<T> type) {
        if (type == null) {
            return Set.of();
        }
        var interfaces = new HashSet<Class<?>>();
        if (type.isInterface()) {
            interfaces.add(type);
        } else {
            interfaces.addAll(List.of(type.getInterfaces()));
            interfaces.addAll(getInterfaces(type.getSuperclass()));
        }
        return interfaces;
    }


    /**
     * Custom exception for conversion errors.
     */
    public static class ConversionException extends Exception {
        public ConversionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
