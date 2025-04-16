package io.github.sibmaks.spring.jfr.event.recording.component;

import io.github.sibmaks.spring.jfr.event.api.common.InvocationExecutedFact;
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
@Label("Component Method Executed Event")public class ComponentMethodExecutedEvent extends Event implements InvocationExecutedFact {
    private final String invocationId;
}
