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
@Label("Controller Method Called Event")
public class ControllerMethodCalledEvent extends Event {
    @Label("Invocation Id")
    private final String invocationId;
    @Label("Class Name")
    private final String className;
    @Label("Method Name")
    private final String methodName;
    @Label("Method")
    private final String method;
    @Label("URL")
    private final String url;
    @Label("Rest")
    private final boolean rest;
}
