package io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ConnectionActionFailedFact {
    @Name("connectionId")
    @Label("Generated Connection Id")
    String getConnectionId();

    @Name("actionIndex")
    @Label("Action Index")
    long getActionIndex();

    @Name("exceptionClass")
    @Label("Exception Class")
    String getExceptionClass();

    @Name("exceptionMessage")
    @Label("Exception Message")
    String getExceptionMessage();
}
