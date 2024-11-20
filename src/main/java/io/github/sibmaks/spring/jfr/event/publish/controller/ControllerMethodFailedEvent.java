package io.github.sibmaks.spring.jfr.event.publish.controller;

import io.github.sibmaks.spring.jfr.event.api.controller.ControllerMethodFailedFact;
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
public class ControllerMethodFailedEvent extends Event implements ControllerMethodFailedFact {
    private final String invocationId;
    private final String exceptionClass;
    private final String exceptionMessage;
}
