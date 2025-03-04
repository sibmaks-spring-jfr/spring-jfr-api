package io.github.sibmaks.spring.jfr.event.reading.core;

import jdk.jfr.consumer.RecordedEvent;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.bytebuddy.matcher.ElementMatchers;

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

        try (var eventBuilder = new ByteBuddy()
                .subclass(Object.class)
                .implement(type)
                .method(ElementMatchers.any())
                .intercept(InvocationHandlerAdapter.of(new RecordedEventInvocationHandler<>(event, type)))
                .make()) {

            var byteBuddy = eventBuilder
                    .load(type.getClassLoader())
                    .getLoaded()
                    .getDeclaredConstructor()
                    .newInstance();

            return (T) byteBuddy;
        } catch (Exception e) {
            throw new ConversionException("Error converting RecordedEvent to " + type.getName(), e);
        }
    }

}