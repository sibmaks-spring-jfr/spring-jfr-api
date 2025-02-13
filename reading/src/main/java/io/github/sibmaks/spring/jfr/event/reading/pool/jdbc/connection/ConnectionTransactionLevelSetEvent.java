package io.github.sibmaks.spring.jfr.event.reading.pool.jdbc.connection;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.ConnectionTransactionLevelSetFact;
import io.github.sibmaks.spring.jfr.event.reading.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ConnectionTransactionLevelSetEvent extends ConnectionTransactionLevelSetFact, RecordedData {
}
