package io.github.sibmaks.spring.jfr.event.recording.kafka.consumer.topic;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.topic.KafkaConsumerTopicsUnsubscribedFact;
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
@StackTrace(false)
@Category(Categories.KAFKA_CONSUMER)
@Label("Kafka Consumer Topics Unsubscribed")public class KafkaConsumerTopicsUnsubscribedEvent extends Event implements KafkaConsumerTopicsUnsubscribedFact {
    private final String consumerId;
    private final String topics;
}
