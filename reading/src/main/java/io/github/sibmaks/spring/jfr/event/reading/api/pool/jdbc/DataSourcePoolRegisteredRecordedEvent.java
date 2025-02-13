package io.github.sibmaks.spring.jfr.event.reading.api.pool.jdbc;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.DataSourcePoolRegisteredFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface DataSourcePoolRegisteredRecordedEvent extends DataSourcePoolRegisteredFact, RecordedData {
}
