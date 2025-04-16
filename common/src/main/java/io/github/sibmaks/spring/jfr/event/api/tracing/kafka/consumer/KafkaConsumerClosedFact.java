package io.github.sibmaks.spring.jfr.event.api.tracing.kafka.consumer;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.24
 */
public interface KafkaConsumerClosedFact {

    @Name("consumerId")
    @Label("Consumer Id")
    String getConsumerId();

}
