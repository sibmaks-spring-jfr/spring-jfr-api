package io.github.sibmaks.spring.jfr.event.api.tracing.kafka.consumer.topic;

import io.github.sibmaks.spring.jfr.event.core.converter.ArrayConverter;
import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerTopicsUnsubscribedFact {

    @Name("consumerId")
    @Label("Consumer Id")
    String getConsumerId();

    @Name("topics")
    @Label("Topics")
    String getTopics();

    /**
     * Get topics as array
     *
     * @return topics array
     */
    default String[] getTopicsAsArray() {
        var topics = getTopics();
        return ArrayConverter.convert(topics);
    }
}
