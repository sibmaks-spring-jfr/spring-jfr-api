package io.github.sibmaks.spring.jfr.event.reading.jpa;

import io.github.sibmaks.spring.jfr.event.reading.RecordedData;
import io.github.sibmaks.spring.jfr.event.api.jpa.JPAMethodCalledFact;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface JPAMethodCalledEvent extends JPAMethodCalledFact, RecordedData {
}
