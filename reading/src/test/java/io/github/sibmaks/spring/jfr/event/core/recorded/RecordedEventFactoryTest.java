package io.github.sibmaks.spring.jfr.event.core.recorded;

import io.github.sibmaks.spring.jfr.event.reading.core.ConversionException;
import io.github.sibmaks.spring.jfr.event.reading.core.RecordedEventProxyFactory;
import io.github.sibmaks.spring.jfr.event.reading.core.recorded.RecordedEventFactory;
import jdk.jfr.EventType;
import jdk.jfr.consumer.RecordedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author sibmaks
 * @since 0.0.15
 */
@ExtendWith(MockitoExtension.class)
class RecordedEventFactoryTest {
    @Mock
    private RecordedEventProxyFactory recordedEventProxyFactory;
    @InjectMocks
    private RecordedEventFactory factory;

    @Test
    void convertNotSupportedType() throws ConversionException {
        var recordedEvent = mock(RecordedEvent.class);

        var eventType = mock(EventType.class);
        when(recordedEvent.getEventType())
                .thenReturn(eventType);

        when(eventType.getName())
                .thenReturn(Object.class.getName());

        var convert = factory.convert(recordedEvent);
        assertNull(convert);

        verify(recordedEventProxyFactory, never())
                .create(eq(recordedEvent), any());
    }

    @Test
    void convertBeanEvent() throws ConversionException {
        var recordedEvent = mock(RecordedEvent.class);

        var eventType = mock(EventType.class);
        when(recordedEvent.getEventType())
                .thenReturn(eventType);

        when(eventType.getName())
                .thenReturn(StubEvent.class.getName());

        var excepted = mock(StubRecordedEvent.class);
        when(recordedEventProxyFactory.create(recordedEvent, StubRecordedEvent.class))
                .thenReturn(excepted);

        var actual = factory.convert(recordedEvent);
        assertEquals(excepted, actual);
    }

    @Test
    void convertBeanEventWhenClassNotExists() {
        var recordedEvent = mock(RecordedEvent.class);

        var eventType = mock(EventType.class);
        when(recordedEvent.getEventType())
                .thenReturn(eventType);

        when(eventType.getName())
                .thenReturn(UUID.randomUUID().toString());

        var actual = factory.convert(recordedEvent);
        assertNull(actual);
    }

    @Test
    void convertWhenConversionException() throws ConversionException {
        var recordedEvent = mock(RecordedEvent.class);

        var eventType = mock(EventType.class);
        when(recordedEvent.getEventType())
                .thenReturn(eventType);

        var typeName = StubEvent.class.getName();
        when(eventType.getName())
                .thenReturn(typeName);

        var childException = new ConversionException(UUID.randomUUID().toString(), new Exception());
        when(recordedEventProxyFactory.create(recordedEvent, StubRecordedEvent.class))
                .thenThrow(childException);

        var exception = assertThrows(IllegalArgumentException.class, () -> factory.convert(recordedEvent));
        assertEquals("Error converting RecordedEvent to " + typeName, exception.getMessage());
        assertEquals(exception.getCause(), childException);
    }
}