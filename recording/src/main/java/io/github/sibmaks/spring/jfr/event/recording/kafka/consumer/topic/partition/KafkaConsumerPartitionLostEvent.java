package io.github.sibmaks.spring.jfr.event.recording.kafka.consumer.topic.partition;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.topic.partition.KafkaConsumerPartitionLostFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer.topic.partition.KafkaConsumerPartitionLostRecordedEvent;
import io.github.sibmaks.spring.jfr.event.reading.core.recorded.RecordedEventType;
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
@StackTrace(value = false)
@Category(Categories.KAFKA_CONSUMER)
@Label("Kafka Consumer Partition Lost")
@RecordedEventType(KafkaConsumerPartitionLostRecordedEvent.class)
public class KafkaConsumerPartitionLostEvent extends Event implements KafkaConsumerPartitionLostFact {
    private final String consumerId;
    private final String partitions;
}
