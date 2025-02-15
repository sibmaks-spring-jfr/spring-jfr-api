package io.github.sibmaks.spring.jfr.event.recording.component;

import io.github.sibmaks.spring.jfr.event.api.component.ComponentMethodCalledFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.core.recorded.RecordedEventType;
import io.github.sibmaks.spring.jfr.event.reading.api.component.ComponentMethodCalledRecordedEvent;
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
@Category(Categories.COMPONENT)
@Label("Component Method Invoked Event")
@RecordedEventType(ComponentMethodCalledRecordedEvent.class)
public class ComponentMethodCalledEvent extends Event implements ComponentMethodCalledFact {
    private final String contextId;
    private final String correlationId;
    private final String invocationId;
    private final String className;
    private final String methodName;
}
