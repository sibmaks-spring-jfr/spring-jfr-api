package io.github.sibmaks.spring.jfr.event.recording.kafka.consumer.commit;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.commit.KafkaConsumerCommitFailedFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer.commit.KafkaConsumerCommitFailedRecordedEvent;
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
@Label("Kafka Consumer Commit Failed")
@RecordedEventType(KafkaConsumerCommitFailedRecordedEvent.class)
public class KafkaConsumerCommitFailedEvent extends Event implements KafkaConsumerCommitFailedFact {
    private final String commitId;
    private final String exceptionClass;
    private final String exceptionMessage;
}
