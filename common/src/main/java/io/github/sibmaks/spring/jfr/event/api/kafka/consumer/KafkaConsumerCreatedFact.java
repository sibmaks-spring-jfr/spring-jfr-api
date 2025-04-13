package io.github.sibmaks.spring.jfr.event.api.kafka.consumer;

import io.github.sibmaks.spring.jfr.event.core.converter.ArrayConverter;
import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerCreatedFact {

    @Name("contextId")
    @Label("Spring Context Id")
    String getContextId();

    @Name("consumerId")
    @Label("Consumer Id")
    String getConsumerId();

    @Name("bootstrapServers")
    @Label("Bootstrap Servers")
    String getBootstrapServers();

    @Name("consumerGroup")
    @Label("Consumer Group")
    String getConsumerGroup();

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
