package io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ConnectionActionRequestedFact {
    @Name("connectionId")
    @Label("Generated Connection Id")
    String getConnectionId();

    @Name("action")
    @Label("Action")
    String getAction();

    default ConnectionAction getConnectionAction() {
        var action = getAction();
        return ConnectionAction.valueOf(action);
    }
}
