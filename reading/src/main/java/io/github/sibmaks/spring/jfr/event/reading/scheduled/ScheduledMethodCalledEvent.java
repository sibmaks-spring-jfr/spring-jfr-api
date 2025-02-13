package io.github.sibmaks.spring.jfr.event.reading.scheduled;

import io.github.sibmaks.spring.jfr.event.reading.RecordedData;
import io.github.sibmaks.spring.jfr.event.api.scheduled.ScheduledMethodCalledFact;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ScheduledMethodCalledEvent extends ScheduledMethodCalledFact, RecordedData {
}
