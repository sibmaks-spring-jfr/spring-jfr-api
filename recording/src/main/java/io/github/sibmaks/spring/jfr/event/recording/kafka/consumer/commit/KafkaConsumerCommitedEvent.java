package io.github.sibmaks.spring.jfr.event.recording.kafka.consumer.commit;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.commit.KafkaConsumerCommitedFact;
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
@Label("Kafka Consumer Commited")
public class KafkaConsumerCommitedEvent extends Event implements KafkaConsumerCommitedFact {
    private final String commitId;
}
