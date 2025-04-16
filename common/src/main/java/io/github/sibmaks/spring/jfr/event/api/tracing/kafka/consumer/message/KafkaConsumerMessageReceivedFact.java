package io.github.sibmaks.spring.jfr.event.api.tracing.kafka.consumer.message;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerMessageReceivedFact {

    @Name("consumerId")
    @Label("Consumer Id")
    String getConsumerId();

    @Name("messageId")
    @Label("Message Id")
    String getMessageId();

}
