package io.github.sibmaks.spring.jfr.event.recording.tracing.pool.jdbc.connection;

import io.github.sibmaks.spring.jfr.event.api.tracing.pool.jdbc.connection.ConnectionRequestedFact;
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
@StackTrace(false)
@AllArgsConstructor
@Category(Categories.POOL_JDBC)
@Label("Connection Requested Event")
public class ConnectionRequestedEvent extends Event implements ConnectionRequestedFact {
    private final String contextId;
    private final String poolId;
    private final String connectionId;
}
