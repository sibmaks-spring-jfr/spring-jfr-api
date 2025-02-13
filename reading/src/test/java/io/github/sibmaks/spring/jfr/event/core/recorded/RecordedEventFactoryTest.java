package io.github.sibmaks.spring.jfr.event.core.recorded;

import io.github.sibmaks.spring.jfr.event.reading.core.RecordedEventProxyFactory;
import io.github.sibmaks.spring.jfr.event.reading.core.recorded.RecordedEventFactory;
import jdk.jfr.EventType;
import jdk.jfr.consumer.RecordedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
    void convertNotSupportedType() throws RecordedEventProxyFactory.ConversionException {
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
    void convertBeanEvent() throws RecordedEventProxyFactory.ConversionException {
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
}