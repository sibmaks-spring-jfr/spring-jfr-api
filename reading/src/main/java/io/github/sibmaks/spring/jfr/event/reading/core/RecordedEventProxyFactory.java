package io.github.sibmaks.spring.jfr.event.reading.core;

import io.github.sibmaks.spring.jfr.event.utils.ReflectionUtils;
import jdk.jfr.Name;
import jdk.jfr.consumer.RecordedEvent;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * Converter to transform RecordedEvent into a specified type.
 *
 * @author sibmaks
 * @since 0.0.9
 */
public class RecordedEventProxyFactory {

    /**
     * Create a Proxy for a RecordedEvent to an instance of the specified type.
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

        var methods = ReflectionUtils.getMethods(type);
        var methods2Name = new HashMap<Method, String>();

        for (var method : methods) {
            var name = method.getAnnotation(Name.class);
            if (name == null) {
                continue;
            }
            methods2Name.put(method, name.value());
        }

        var classLoader = type.getClassLoader();
        var interfaces = ReflectionUtils.getInterfaces(type).toArray(Class[]::new);

        var handler = new RecordedEventProxyHandler<>(methods2Name, event, type);
        try {
            return (T) Proxy.newProxyInstance(
                    classLoader,
                    interfaces,
                    handler
            );
        } catch (Exception e) {
            throw new ConversionException("Error converting RecordedEvent to " + type.getName(), e);
        }
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
