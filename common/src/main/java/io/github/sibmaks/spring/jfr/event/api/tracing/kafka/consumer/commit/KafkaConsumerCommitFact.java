package io.github.sibmaks.spring.jfr.event.api.tracing.kafka.consumer.commit;

import io.github.sibmaks.spring.jfr.event.core.converter.ArrayConverter;
import jdk.jfr.Label;
import jdk.jfr.Name;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sibmaks
 * @since 0.0.23
 */
public interface KafkaConsumerCommitFact {

    @Name("consumerId")
    @Label("Consumer Id")
    String getConsumerId();

    @Name("commitId")
    @Label("Commit Id")
    String getCommitId();

    @Name("async")
    @Label("Async")
    boolean isAsync();

    @Name("offsets")
    @Label("Offsets")
    String getOffsets();

    /**
     * Get offsets as map
     *
     * @return offsets map
     */
    default Map<Map.Entry<String, Integer>, String> getOffsetsAsMap() {
        var offsets = getOffsets();
        var offsetsMap = new HashMap<Map.Entry<String, Integer>, String>();
        var offsetsAsArray = ArrayConverter.convert(offsets);
        for (int i = 0; i < offsetsAsArray.length; i += 2) {
            var key = offsetsAsArray[i];
            var keyOffset = key.lastIndexOf('-');
            var topic = key.substring(0, keyOffset);
            var partition = Integer.parseInt(key.substring(keyOffset + 1));
            var value = offsetsAsArray[i + 1];
            offsetsMap.put(Map.entry(topic, partition), value);
        }
        return offsetsMap;
    }

}
