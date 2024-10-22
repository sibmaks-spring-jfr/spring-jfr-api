package io.github.sibmaks.spring.jfr.event.controller;

import jdk.jfr.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Category("Spring Controller Flight Recorder")
@Name("io.github.sibmaks.spring.jfr.event.controller.ControllerInvocationEvent")
@Label("Controller Invocation Event")
public class ControllerInvocationEvent extends Event {
    @Label("Method Name")
    private final String methodName;
    @Label("Method")
    private final String method;
    @Label("URL")
    private final String url;
    @Label("Exception")
    private String exception;

    public ControllerInvocationEvent(
            String methodName,
            String method,
            String url
    ) {
        this.methodName = methodName;
        this.method = method;
        this.url = url;
    }

}
