package io.github.sibmaks.spring.jfr.event.controller;

import io.github.sibmaks.spring.jfr.event.constant.Constants;
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
@Category(Constants.CATEGORY_CONTROLLER)
@Label("Controller Method Executed Event")
public class ControllerMethodExecutedEvent extends Event {
    @Label("Invocation Id")
    private final String invocationId;
}
