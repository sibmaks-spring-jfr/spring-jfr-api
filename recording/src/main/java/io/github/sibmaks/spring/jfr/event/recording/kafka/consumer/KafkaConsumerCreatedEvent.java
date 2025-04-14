package io.github.sibmaks.spring.jfr.event.recording.kafka.consumer;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.KafkaConsumerCreatedFact;
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
 * @since 0.0.23
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace(value = false)
@Category(Categories.KAFKA_CONSUMER)
@Label("Kafka Consumer Created Event")

public class KafkaConsumerCreatedEvent extends Event implements KafkaConsumerCreatedFact {
    private final String contextId;
    private final String consumerFactory;
    private final String consumerId;
    private final String bootstrapServers;
    private final String consumerGroup;
    private final String topics;
}
