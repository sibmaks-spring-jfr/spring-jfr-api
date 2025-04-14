package io.github.sibmaks.spring.jfr.event.recording.pool.jdbc.connection.action;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action.ConnectionActionFailedFact;
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
@StackTrace
@Category(Categories.POOL_JDBC)
@Label("Connection Action Failed Event")

public class ConnectionActionFailedEvent extends Event implements ConnectionActionFailedFact {
    private final String connectionId;
    private final long actionIndex;
    private final String exceptionClass;
    private final String exceptionMessage;
}
