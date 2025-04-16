package io.github.sibmaks.spring.jfr.event.api.tracing.pool.jdbc.connection.action;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public enum ConnectionAction {
    CREATE,
    CLOSE,
    COMMIT,
    ROLLBACK,

    EXECUTE,
    EXECUTE_QUERY,
    EXECUTE_UPDATE,
    EXECUTE_BATCH,
    EXECUTE_LARGE_UPDATE,
    EXECUTE_LARGE_BATCH,
}
