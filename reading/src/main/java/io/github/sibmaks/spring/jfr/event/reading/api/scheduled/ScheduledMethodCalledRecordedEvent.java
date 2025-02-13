package io.github.sibmaks.spring.jfr.event.reading.api.scheduled;

import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;
import io.github.sibmaks.spring.jfr.event.api.scheduled.ScheduledMethodCalledFact;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface ScheduledMethodCalledRecordedEvent extends ScheduledMethodCalledFact, RecordedData {
}
