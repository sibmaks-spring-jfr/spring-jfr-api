package io.github.sibmaks.spring.jfr.event.reading.api.service;

import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;
import io.github.sibmaks.spring.jfr.event.api.service.ServiceMethodCalledFact;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ServiceMethodCalledRecordedEvent extends ServiceMethodCalledFact, RecordedData {
}
