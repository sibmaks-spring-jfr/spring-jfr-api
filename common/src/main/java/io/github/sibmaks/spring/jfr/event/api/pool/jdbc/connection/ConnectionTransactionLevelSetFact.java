package io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ConnectionTransactionLevelSetFact {
    @Name("connectionId")
    @Label("Generated Connection Id")
    String getConnectionId();

    @Name("transactionLevel")
    @Label("Transaction Level")
    int getTransactionLevel();

}
