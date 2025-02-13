package io.github.sibmaks.spring.jfr.event.reading.controller;

import io.github.sibmaks.spring.jfr.event.reading.RecordedData;
import io.github.sibmaks.spring.jfr.event.api.controller.ControllerMethodCalledFact;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ControllerMethodCalledEvent extends ControllerMethodCalledFact, RecordedData {
}
