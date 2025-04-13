package io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer.message;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.message.KafkaConsumerMessageProcessedFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerMessageProcessedRecordedEvent extends KafkaConsumerMessageProcessedFact, RecordedData {
}
