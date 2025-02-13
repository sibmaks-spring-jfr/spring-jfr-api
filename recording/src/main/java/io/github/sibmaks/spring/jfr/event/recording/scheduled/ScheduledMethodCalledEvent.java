package io.github.sibmaks.spring.jfr.event.recording.scheduled;

import io.github.sibmaks.spring.jfr.event.api.scheduled.ScheduledMethodCalledFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.core.recorded.RecordedEventType;
import io.github.sibmaks.spring.jfr.event.reading.api.scheduled.ScheduledMethodCalledRecordedEvent;
import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace
@Category(Categories.SCHEDULED)
@Label("Scheduled Method Invoked Event")
@RecordedEventType(ScheduledMethodCalledRecordedEvent.class)
public class ScheduledMethodCalledEvent extends Event implements ScheduledMethodCalledFact {
    private final String contextId;
    private final String invocationId;
    private final String className;
    private final String methodName;
}
