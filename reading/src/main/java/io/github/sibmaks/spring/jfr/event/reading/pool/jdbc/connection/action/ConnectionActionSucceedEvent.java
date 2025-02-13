package io.github.sibmaks.spring.jfr.event.reading.pool.jdbc.connection.action;

import io.github.sibmaks.spring.jfr.event.api.pool.jdbc.connection.action.ConnectionActionSucceedFact;
import io.github.sibmaks.spring.jfr.event.reading.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ConnectionActionSucceedEvent extends ConnectionActionSucceedFact, RecordedData {
}
