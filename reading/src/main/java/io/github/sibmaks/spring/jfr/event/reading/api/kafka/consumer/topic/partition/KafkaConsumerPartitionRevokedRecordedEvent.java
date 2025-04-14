package io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer.topic.partition;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.topic.partition.KafkaConsumerPartitionRevokedFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.28
 */
public interface KafkaConsumerPartitionRevokedRecordedEvent extends KafkaConsumerPartitionRevokedFact, RecordedData {
}
