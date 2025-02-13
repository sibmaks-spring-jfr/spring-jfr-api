package io.github.sibmaks.spring.jfr.event.reading.bean;

import io.github.sibmaks.spring.jfr.event.reading.RecordedData;
import io.github.sibmaks.spring.jfr.event.api.bean.PostProcessAfterInitializationFact;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface PostProcessAfterInitializationEvent extends PostProcessAfterInitializationFact, RecordedData {
}
