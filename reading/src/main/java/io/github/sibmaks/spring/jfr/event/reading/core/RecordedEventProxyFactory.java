package io.github.sibmaks.spring.jfr.event.reading.core;

import io.github.sibmaks.spring.jfr.event.utils.ReflectionUtils;
import jdk.jfr.consumer.RecordedEvent;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Converter to transform RecordedEvent into a specified type.
 *
 * @author sibmaks
 * @since 0.0.9
 */
public class RecordedEventProxyFactory {
    private final Map<Class<?>, Function<RecordedEvent, ?>> cachedProxyFactories = new ConcurrentHashMap<>();

    /**
     * Create a Proxy for a RecordedEvent to an instance of the specified type.
     *
     * @param event the RecordedEvent to convert
     * @param type  the target class type
     * @param <T>   the type parameter
     * @return an instance of type T populated with event data
     * @throws ConversionException if the conversion fails
     */
    public <T> T create(RecordedEvent event, Class<T> type) {
        if (event == null) {
            throw new IllegalArgumentException("RecordedEvent cannot be null");
        }
        if (type == null) {
            throw new IllegalArgumentException("Target type cannot be null");
        }
        var proxyFactory = cachedProxyFactories.computeIfAbsent(type, RecordedEventProxyFactory::buildProxyFactory);
        return (T) proxyFactory.apply(event);
    }

    private static <T> Function<RecordedEvent, Object> buildProxyFactory(Class<T> type) {
        var classLoader = Optional.ofNullable(type.getClassLoader())
                .orElseGet(RecordedEventProxyFactory.class::getClassLoader);
        var interfaces = ReflectionUtils.getInterfaces(type).toArray(Class[]::new);

        return recordedEvent -> {
            var handler = new RecordedEventProxyHandler<>(recordedEvent, type);
            try {
                return (T) Proxy.newProxyInstance(
                        classLoader,
                        interfaces,
                        handler
                );
            } catch (Exception e) {
                throw new ConversionException("Error converting RecordedEvent to " + type.getName(), e);
            }
        };
    }

}