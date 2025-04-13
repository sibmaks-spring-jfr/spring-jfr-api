package io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer.topic;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.topic.KafkaConsumerTopicsSubscribedFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerTopicsSubscribedRecordedEvent extends KafkaConsumerTopicsSubscribedFact, RecordedData {
}
