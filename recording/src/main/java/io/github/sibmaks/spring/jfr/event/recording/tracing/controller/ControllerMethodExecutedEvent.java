package io.github.sibmaks.spring.jfr.event.recording.tracing.controller;

import io.github.sibmaks.spring.jfr.event.api.tracing.common.InvocationExecutedFact;
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
@Category(Categories.CONTROLLER)
@Label("Controller Method Executed Event")
public class ControllerMethodExecutedEvent extends Event implements InvocationExecutedFact {
    private final String invocationId;
}
