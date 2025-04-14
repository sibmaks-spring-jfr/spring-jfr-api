package io.github.sibmaks.spring.jfr.event.recording.controller;

import io.github.sibmaks.spring.jfr.event.api.common.InvocationFailedFact;
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
@Label("Controller Method Failed Event")

public class ControllerMethodFailedEvent extends Event implements InvocationFailedFact {
    private final String invocationId;
    private final String exceptionClass;
    private final String exceptionMessage;
}
