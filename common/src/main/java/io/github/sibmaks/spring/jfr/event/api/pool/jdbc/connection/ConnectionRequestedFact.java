package io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action.ConnectionAction;
import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action.ConnectionActionRequestedFact;
import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.17
 */
public interface ConnectionRequestedFact extends ConnectionActionRequestedFact {
    @Name("contextId")
    @Label("Context Id")
    String getContextId();

    @Name("poolId")
    @Label("Generated Pool Id")
    String getPoolId();

    @Override
    default long getActionIndex() {
        return 0;
    }

    @Override
    default String getAction() {
        return ConnectionAction.CREATE.name();
    }

    @Override
    default ConnectionAction getConnectionAction() {
        return ConnectionAction.CREATE;
    }
}
