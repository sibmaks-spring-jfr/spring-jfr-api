package io.github.sibmaks.spring.jfr.event.reading.api.pool.jdbc.connection;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.ConnectionTransactionLevelSetFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ConnectionTransactionLevelSetRecordedEvent extends ConnectionTransactionLevelSetFact, RecordedData {
}
