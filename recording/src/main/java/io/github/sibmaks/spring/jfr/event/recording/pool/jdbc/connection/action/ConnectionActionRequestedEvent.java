package io.github.sibmaks.spring.jfr.event.recording.pool.jdbc.connection.action;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action.ConnectionAction;
import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action.ConnectionActionRequestedFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.api.pool.jdbc.connection.action.ConnectionActionRequestedRecordedEvent;
import io.github.sibmaks.spring.jfr.event.reading.core.recorded.RecordedEventType;
import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@StackTrace
@Category(Categories.POOL_JDBC)
@Label("Connection Action Requested Event")
@RecordedEventType(ConnectionActionRequestedRecordedEvent.class)
public class ConnectionActionRequestedEvent extends Event implements ConnectionActionRequestedFact {
    private final String connectionId;
    private final long actionIndex;
    private final String action;

    @Builder
    public ConnectionActionRequestedEvent(String connectionId, long actionIndex, ConnectionAction action) {
        this.connectionId = connectionId;
        this.actionIndex = actionIndex;
        this.action = action.name();
    }
}
