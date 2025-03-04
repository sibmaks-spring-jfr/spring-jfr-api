package io.github.sibmaks.spring.jfr.event.reading.core;

import jdk.jfr.Name;
import jdk.jfr.consumer.RecordedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author sibmaks
 * @since 0.0.21
 */
@ExtendWith(MockitoExtension.class)
class RecordedEventProxyFactoryTest {
    @InjectMocks
    private RecordedEventProxyFactory factory;

    @Test
    void createParentProxy() throws ConversionException, NoSuchMethodException {
        var event = mock(RecordedEvent.class);

        var startTime = Instant.now();
        when(event.getStartTime())
                .thenReturn(startTime);

        var returnSomething = UUID.randomUUID().toString();
        when(event.getValue("returnSomething"))
                .thenReturn(returnSomething);

        var parent = factory.create(event, Parent.class);

        var actualStartTime = parent.getStartTime();
        assertEquals(startTime, actualStartTime);

        var actualReturnSomething = parent.returnSomething();
        assertEquals(returnSomething, actualReturnSomething);

        var exception = assertThrows(IllegalArgumentException.class, parent::doSomething);
        var doSomethingMethod = Parent.class.getDeclaredMethod("doSomething");
        assertEquals(
                "Unknown method " + doSomethingMethod,
                exception.getMessage()
        );

        var parentAsString = parent.toString();
        assertEquals("Proxy for " + Parent.class.getName(), parentAsString);

        var exceptionToString = assertThrows(
                IllegalArgumentException.class,
                () -> parent.toString(UUID.randomUUID().toString())
        );
        var toStringMethod = Parent.class.getDeclaredMethod("toString", String.class);
        assertEquals(
                exceptionToString.getMessage(),
                "Unknown method " + toStringMethod
        );
    }

    @Test
    void createChildProxy() throws ConversionException {
        var event = mock(RecordedEvent.class);

        var startTime = Instant.now();
        when(event.getStartTime())
                .thenReturn(startTime);

        var child = factory.create(event, Child.class);

        var actualStartTime = child.getStartTime();
        assertEquals(startTime, actualStartTime);

        var actualReturnSomething = child.returnSomething();
        assertNotNull(actualReturnSomething);

        try {
            child.doSomething();
        } catch (Exception e) {
            fail("Default method's should be called successfully", e);
        }

        var childAsString = child.toString();
        assertEquals("Proxy for " + Child.class.getName(), childAsString);

        var toStringArg = UUID.randomUUID().toString();
        var childAsCustomString = child.toString(toStringArg);
        assertEquals(toStringArg, childAsCustomString);
    }

    @Test
    void createWhenEventIsNull() {
        var exception = assertThrows(IllegalArgumentException.class, () -> factory.create(null, null));
        assertEquals("RecordedEvent cannot be null", exception.getMessage());
    }

    @Test
    void createWhenTypeIsNull() {
        var event = mock(RecordedEvent.class);
        var exception = assertThrows(IllegalArgumentException.class, () -> factory.create(event, null));
        assertEquals("Target type cannot be null", exception.getMessage());
    }

    @Test
    void create_whenTargetTypeIsNotInterface_throwsConversionException() {
        var event = mock(RecordedEvent.class);

        var exception = assertThrows(ConversionException.class, () ->
                factory.create(event, NonInterfaceTarget.class)
        );
        assertEquals("Error converting RecordedEvent to " + NonInterfaceTarget.class.getName(), exception.getMessage());
    }

    public interface Parent {
        void doSomething();

        @Name("returnSomething")
        String returnSomething();

        Instant getStartTime();

        String toString(String value);
    }

    public interface Child extends Parent {
        @Override
        default void doSomething() {
            System.out.println("doSomething");
        }

        @Override
        default String returnSomething() {
            return UUID.randomUUID().toString();
        }

        @Override
        default String toString(String value) {
            return value;
        }
    }

    static class NonInterfaceTarget {
        @SuppressWarnings("unused")
        public String getValue() {
            return "test";
        }
    }
}