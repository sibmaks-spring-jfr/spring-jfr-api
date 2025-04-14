package io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.17
 */
public interface ConnectionRequestedFact {
    @Name("contextId")
    @Label("Context Id")
    String getContextId();

    @Name("poolId")
    @Label("Generated Pool Id")
    String getPoolId();

    @Name("connectionId")
    @Label("Generated Connection Id")
    String getConnectionId();
}
