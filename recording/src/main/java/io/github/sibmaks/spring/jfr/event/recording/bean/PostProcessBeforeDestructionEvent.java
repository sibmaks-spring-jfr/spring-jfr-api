package io.github.sibmaks.spring.jfr.event.recording.bean;

import io.github.sibmaks.spring.jfr.event.api.bean.PostProcessBeforeDestructionFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.core.recorded.RecordedEventType;
import io.github.sibmaks.spring.jfr.event.reading.api.bean.PostProcessBeforeDestructionRecordedEvent;
import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author sibmaks
 * @since 0.0.11
 */
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Category(Categories.BEAN)
@Label("Post Process Before Destruction Invoked")
@RecordedEventType(PostProcessBeforeDestructionRecordedEvent.class)
public class PostProcessBeforeDestructionEvent extends Event implements PostProcessBeforeDestructionFact {
    private final String contextId;
    private final String beanName;
}
