package io.github.sibmaks.spring.jfr.event.recording.async;

import io.github.sibmaks.spring.jfr.event.api.common.InvocationExecutedFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.core.recorded.RecordedEventType;
import io.github.sibmaks.spring.jfr.event.reading.api.common.InvocationExecutedRecordedEvent;
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
@StackTrace(false)
@Category(Categories.ASYNC)
@Label("Async Method Called Event")
@RecordedEventType(InvocationExecutedRecordedEvent.class)
public class AsyncMethodExecutedEvent extends Event implements InvocationExecutedFact {
    private final String invocationId;
}
