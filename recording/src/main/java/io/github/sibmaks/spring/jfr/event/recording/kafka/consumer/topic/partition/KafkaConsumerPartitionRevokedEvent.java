package io.github.sibmaks.spring.jfr.event.recording.kafka.consumer.topic.partition;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.topic.partition.KafkaConsumerPartitionRevokedFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sibmaks
 * @since 0.0.28
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Category(Categories.KAFKA_CONSUMER)
@Label("Kafka Consumer Partition Revoked")public class KafkaConsumerPartitionRevokedEvent extends Event implements KafkaConsumerPartitionRevokedFact {
    private final String consumerId;
    private final String partitions;
}
