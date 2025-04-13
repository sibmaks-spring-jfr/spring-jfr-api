package io.github.sibmaks.spring.jfr.event.api.kafka.consumer.message;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerMessageFailedFact {

    @Name("messageId")
    @Label("Message Id")
    String getMessageId();

    @Name("exceptionClass")
    @Label("Exception Class")
    String getExceptionClass();

    @Name("exceptionMessage")
    @Label("Exception Message")
    String getExceptionMessage();

}
