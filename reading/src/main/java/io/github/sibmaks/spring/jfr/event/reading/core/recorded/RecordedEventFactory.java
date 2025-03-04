package io.github.sibmaks.spring.jfr.event.reading.core.recorded;

import io.github.sibmaks.spring.jfr.event.reading.core.RecordedEventProxyFactory;
import jdk.jfr.consumer.RecordedEvent;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public class RecordedEventFactory {

    private final RecordedEventProxyFactory recordedEventProxyFactory;
    private final Map<Class<?>, Class<?>> recorded2readingMap;

    public RecordedEventFactory(RecordedEventProxyFactory recordedEventProxyFactory) {
        this.recordedEventProxyFactory = recordedEventProxyFactory;
        this.recorded2readingMap = new ConcurrentHashMap<>();
    }

    private static Class<?> extractRecordedEventType(Class<?> it) {
        return Optional.ofNullable(it.getAnnotation(RecordedEventType.class))
                .map(RecordedEventType::value)
                .orElse(null);
    }

    public Object convert(RecordedEvent event) {
        var eventType = event.getEventType();
        var eventTypeName = eventType.getName();
        var eventClass = getaClass(eventTypeName);
        if (eventClass == null) return null;
        try {
            return recordedEventProxyFactory.create(event, eventClass);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting RecordedEvent to " + eventTypeName, e);
        }
    }

    private Class<?> getaClass(String typeName) {
        Class<?> type;
        try {
            type = Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            return null;
        }
        return recorded2readingMap.computeIfAbsent(type, RecordedEventFactory::extractRecordedEventType);
    }

}
