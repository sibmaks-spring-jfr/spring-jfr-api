package io.github.sibmaks.spring.jfr.event.api.kafka.consumer.commit;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerCommitFailedFact {

    @Name("commitId")
    @Label("Commit Id")
    String getCommitId();

    @Name("exceptionClass")
    @Label("Exception Class")
    String getExceptionClass();

    @Name("exceptionMessage")
    @Label("Exception Message")
    String getExceptionMessage();

}
