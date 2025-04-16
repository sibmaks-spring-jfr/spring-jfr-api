package io.github.sibmaks.spring.jfr.event.recording.pool.jdbc.connection;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.ConnectionTransactionLevelSetFact;
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
@Label("Connection Transaction Level Set Event")
public class ConnectionTransactionLevelSetEvent extends Event implements ConnectionTransactionLevelSetFact {
    private final String connectionId;
    private final int transactionLevel;
}
