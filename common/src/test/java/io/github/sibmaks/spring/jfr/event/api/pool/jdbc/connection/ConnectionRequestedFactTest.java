package io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action.ConnectionAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author sibmaks
 * @since 0.0.21
 */
@ExtendWith(MockitoExtension.class)
class ConnectionRequestedFactTest {
    @Mock
    private ConnectionRequestedFact fact;

    @Test
    void testGetActionIndex() {
        when(fact.getActionIndex())
                .thenCallRealMethod();

        assertEquals(0, fact.getActionIndex());
    }

    @Test
    void testGetAction() {
        when(fact.getAction())
                .thenCallRealMethod();

        assertEquals(ConnectionAction.CREATE.name(), fact.getAction());
    }

    @Test
    void testGetConnectionAction() {
        when(fact.getConnectionAction())
                .thenCallRealMethod();

        assertEquals(ConnectionAction.CREATE, fact.getConnectionAction());
    }

}