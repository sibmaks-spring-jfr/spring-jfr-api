package io.github.sibmaks.spring.jfr.event.reading.service;

import io.github.sibmaks.spring.jfr.event.reading.RecordedData;
import io.github.sibmaks.spring.jfr.event.api.service.ServiceMethodCalledFact;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ServiceMethodCalledEvent extends ServiceMethodCalledFact, RecordedData {
}
