package io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer.topic;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.topic.KafkaConsumerTopicsUnsubscribedFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerTopicsUnsubscribedRecordedEvent extends KafkaConsumerTopicsUnsubscribedFact, RecordedData {
}
