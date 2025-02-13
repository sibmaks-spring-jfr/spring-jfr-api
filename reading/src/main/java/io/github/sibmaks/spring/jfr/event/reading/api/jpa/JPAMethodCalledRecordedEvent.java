package io.github.sibmaks.spring.jfr.event.reading.api.jpa;

import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;
import io.github.sibmaks.spring.jfr.event.api.jpa.JPAMethodCalledFact;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface JPAMethodCalledRecordedEvent extends JPAMethodCalledFact, RecordedData {
}
