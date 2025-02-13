package io.github.sibmaks.spring.jfr.event.reading.pool.jdbc;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.DataSourcePoolRegisteredFact;
import io.github.sibmaks.spring.jfr.event.reading.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface DataSourcePoolRegisteredEvent extends DataSourcePoolRegisteredFact, RecordedData {
}
