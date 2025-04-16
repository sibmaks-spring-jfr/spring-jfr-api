package io.github.sibmaks.spring.jfr.event.api.tracing.pool.jdbc;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface DataSourcePoolRegisteredFact {
    @Name("contextId")
    @Label("Spring Context Id")
    String getContextId();

    @Name("poolId")
    @Label("Generated Pool Id")
    String getPoolId();

    @Name("poolName")
    @Label("Pool Name")
    String getPoolName();

    @Name("connectionTimeout")
    @Label("Connection Timeout")
    long getConnectionTimeout();

    @Name("idleTimeout")
    @Label("IDLE Timeout")
    long getIdleTimeout();

    @Name("leakDetectionThreshold")
    @Label("Leak Detection Threshold")
    long getLeakDetectionThreshold();

    @Name("maxLifetime")
    @Label("Maximum Lifetime")
    long getMaxLifetime();

    /**
     * Get the maximum pool size of the JPA pool.
     * Negative values indicate unlimited pool size.
     * Zeros indicate no maximum pool size.
     *
     * @return maximum pool size
     */
    @Name("maxPoolSize")
    @Label("Maximum Pool Size")
    long getMaxPoolSize();

    @Name("minimumIdle")
    @Label("Minimum IDLE")
    long getMinimumIdle();

    @Name("validationTimeout")
    @Label("Validation Timeout")
    long getValidationTimeout();

    @Name("keepaliveTime")
    @Label("Keep-Alive Time")
    long getKeepaliveTime();

}
