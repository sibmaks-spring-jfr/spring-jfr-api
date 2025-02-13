package io.github.sibmaks.spring.jfr.event.recording.pool.jdbc.connection.action;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action.ConnectionActionSucceedFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.api.pool.jdbc.connection.action.ConnectionActionSucceedRecordedEvent;
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
@Builder
@AllArgsConstructor
@StackTrace
@Category(Categories.POOL_JDBC)
@Label("Connection Action Succeed Event")
@RecordedEventType(ConnectionActionSucceedRecordedEvent.class)
public class ConnectionActionSucceedEvent extends Event implements ConnectionActionSucceedFact {
    private final String connectionId;
    private final long actionIndex;
}
