package io.github.sibmaks.spring.jfr.event.reading.api.controller;

import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;
import io.github.sibmaks.spring.jfr.event.api.controller.ControllerMethodCalledFact;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ControllerMethodCalledRecordedEvent extends ControllerMethodCalledFact, RecordedData {
}
