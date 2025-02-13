package io.github.sibmaks.spring.jfr.event.reading.core.recorded;

import io.github.sibmaks.spring.jfr.event.reading.core.RecordedEventProxyFactory;
import jdk.jfr.consumer.RecordedEvent;

import java.util.Map;
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
        var annotation = it.getAnnotation(RecordedEventType.class);
        if (annotation == null || annotation.value() == null) {
            return null;
        }
        return annotation.value();
    }

    public Object convert(RecordedEvent event) {
        var eventType = event.getEventType();
        var eventTypeName = eventType.getName();
        try {
            var eventTypeClass = Class.forName(eventTypeName);
            var eventClass = recorded2readingMap.computeIfAbsent(eventTypeClass, RecordedEventFactory::extractRecordedEventType);
            if (eventClass == null) {
                return null;
            }
            return recordedEventProxyFactory.create(event, eventClass);
        } catch (Exception e) {
            throw new RuntimeException("Error converting RecordedEvent to " + eventTypeName, e);
        }
    }

}
