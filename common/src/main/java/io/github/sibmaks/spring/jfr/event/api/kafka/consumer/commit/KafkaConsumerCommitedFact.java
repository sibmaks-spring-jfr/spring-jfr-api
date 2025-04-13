package io.github.sibmaks.spring.jfr.event.api.kafka.consumer.commit;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerCommitedFact {

    @Name("commitId")
    @Label("Commit Id")
    String getCommitId();

}
