package io.github.sibmaks.spring.jfr.event.recording.kafka.consumer;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.KafkaConsumerClosedFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer.KafkaConsumerClosedRecordedEvent;
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
 * @since 0.0.24
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace(value = false)
@Category(Categories.KAFKA_CONSUMER)
@Label("Kafka Consumer Closed Event")
@RecordedEventType(KafkaConsumerClosedRecordedEvent.class)
public class KafkaConsumerClosedEvent extends Event implements KafkaConsumerClosedFact {
    private final String consumerId;
}
