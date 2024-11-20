package io.github.sibmaks.spring.jfr.event.publish.controller;

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
public class ControllerMethodFailedEvent extends Event {
    @Label("Invocation Id")
    private final String invocationId;
    @Label("Exception Class")
    private final String exceptionClass;
    @Label("Exception Message")
    private final String exceptionMessage;
}
