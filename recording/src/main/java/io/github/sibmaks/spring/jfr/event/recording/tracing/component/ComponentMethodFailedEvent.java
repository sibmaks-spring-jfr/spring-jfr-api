package io.github.sibmaks.spring.jfr.event.recording.tracing.component;

import io.github.sibmaks.spring.jfr.event.api.tracing.common.InvocationFailedFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
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
@Category(Categories.COMPONENT)
@Label("Component Method Failed Event")
public class ComponentMethodFailedEvent extends Event implements InvocationFailedFact {
    private final String invocationId;
    private final String exceptionClass;
    private final String exceptionMessage;
}
