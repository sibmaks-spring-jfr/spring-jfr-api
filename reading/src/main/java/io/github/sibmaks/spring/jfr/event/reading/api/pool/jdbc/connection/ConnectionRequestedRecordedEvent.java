package io.github.sibmaks.spring.jfr.event.reading.api.pool.jdbc.connection;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.ConnectionRequestedFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.17
 */
public interface ConnectionRequestedRecordedEvent extends ConnectionRequestedFact, RecordedData {
}
