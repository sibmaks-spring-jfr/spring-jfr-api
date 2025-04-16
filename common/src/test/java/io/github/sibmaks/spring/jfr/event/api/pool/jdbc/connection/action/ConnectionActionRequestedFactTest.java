package io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action;

import io.github.sibmaks.spring.jfr.event.api.tracing.pool.jdbc.connection.action.ConnectionAction;
import io.github.sibmaks.spring.jfr.event.api.tracing.pool.jdbc.connection.action.ConnectionActionRequestedFact;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author sibmaks
 * @since 0.0.15
 */
class ConnectionActionRequestedFactTest {

    @ParameterizedTest
    @EnumSource(ConnectionAction.class)
    void getConnectionAction(ConnectionAction action) {
        var fact = mock(ConnectionActionRequestedFact.class);
        when(fact.getAction())
                .thenReturn(action.name());

        when(fact.getConnectionAction())
                .thenCallRealMethod();

        var actual = fact.getConnectionAction();
        assertEquals(action, actual);
    }
}