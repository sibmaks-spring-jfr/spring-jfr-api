package io.github.sibmaks.spring.jfr.event.api.kafka.consumer.topic.partition;

import io.github.sibmaks.spring.jfr.event.core.converter.ArrayConverter;
import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.28
 */
public interface KafkaConsumerPartitionRevokedFact {

    @Name("consumerId")
    @Label("Consumer Id")
    String getConsumerId();

    @Name("partitions")
    @Label("Partitions")
    String getPartitions();

    /**
     * Get partitions as array
     *
     * @return partitions array
     */
    default String[] getPartitionsAsArray() {
        var partitions = getPartitions();
        return ArrayConverter.convert(partitions);
    }
}
