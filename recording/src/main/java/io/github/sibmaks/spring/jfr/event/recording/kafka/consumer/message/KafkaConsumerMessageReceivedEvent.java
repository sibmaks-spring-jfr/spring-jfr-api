package io.github.sibmaks.spring.jfr.event.recording.kafka.consumer.message;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.message.KafkaConsumerMessageReceivedFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer.message.KafkaConsumerMessageReceivedRecordedEvent;
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
 * @since 0.0.23
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace(value = false)
@Category(Categories.KAFKA_CONSUMER)
@Label("Kafka Consumer Message Received")
@RecordedEventType(KafkaConsumerMessageReceivedRecordedEvent.class)
public class KafkaConsumerMessageReceivedEvent extends Event implements KafkaConsumerMessageReceivedFact {
    private final String consumerId;
    private final String messageId;
}
