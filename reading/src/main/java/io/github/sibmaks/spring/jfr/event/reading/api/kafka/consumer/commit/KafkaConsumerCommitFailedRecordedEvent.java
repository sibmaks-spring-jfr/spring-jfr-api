package io.github.sibmaks.spring.jfr.event.reading.api.kafka.consumer.commit;

import io.github.sibmaks.spring.jfr.event.api.kafka.consumer.commit.KafkaConsumerCommitFailedFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerCommitFailedRecordedEvent extends KafkaConsumerCommitFailedFact, RecordedData {
}
