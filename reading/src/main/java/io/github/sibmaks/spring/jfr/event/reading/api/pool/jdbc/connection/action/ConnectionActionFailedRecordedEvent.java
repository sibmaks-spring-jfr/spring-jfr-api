package io.github.sibmaks.spring.jfr.event.reading.api.pool.jdbc.connection.action;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action.ConnectionActionFailedFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ConnectionActionFailedRecordedEvent extends ConnectionActionFailedFact, RecordedData {
}
