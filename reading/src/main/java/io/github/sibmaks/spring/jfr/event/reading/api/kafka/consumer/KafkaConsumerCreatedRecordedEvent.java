package io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.KafkaConsumerCreatedFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerCreatedRecordedEvent extends KafkaConsumerCreatedFact, RecordedData {
}
