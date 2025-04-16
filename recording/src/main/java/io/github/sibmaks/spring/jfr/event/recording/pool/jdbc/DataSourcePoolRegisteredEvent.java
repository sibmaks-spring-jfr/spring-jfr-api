package io.github.sibmaks.spring.jfr.event.recording.pool.jdbc;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.DataSourcePoolRegisteredFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Category(Categories.POOL_JDBC)
@Label("Data Source Pool Registered Event")public class DataSourcePoolRegisteredEvent extends Event implements DataSourcePoolRegisteredFact {
    private final String contextId;
    private final String poolId;
    private final String poolName;
    private final long connectionTimeout;
    private final long idleTimeout;
    private final long leakDetectionThreshold;
    private final long maxLifetime;
    private final long maxPoolSize;
    private final long minimumIdle;
    private final long validationTimeout;
    private final long keepaliveTime;
}
