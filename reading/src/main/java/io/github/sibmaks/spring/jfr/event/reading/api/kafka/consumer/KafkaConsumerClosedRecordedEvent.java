package io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.KafkaConsumerClosedFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.24
 */
public interface KafkaConsumerClosedRecordedEvent extends KafkaConsumerClosedFact, RecordedData {
}
