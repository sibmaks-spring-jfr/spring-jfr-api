package io.github.sibmaks.spring.jfr.event.recording.pool.jdbc.connection;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.ConnectionRequestedFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.api.pool.jdbc.connection.ConnectionRequestedRecordedEvent;
import io.github.sibmaks.spring.jfr.event.reading.core.recorded.RecordedEventType;
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
@StackTrace
@Builder
@AllArgsConstructor
@Category(Categories.POOL_JDBC)
@Label("Connection Requested Event")
@RecordedEventType(ConnectionRequestedRecordedEvent.class)
public class ConnectionRequestedEvent extends Event implements ConnectionRequestedFact {
    private final String contextId;
    private final String poolId;
    private final String connectionId;
}
