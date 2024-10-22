package io.github.sibmaks.spring.jfr.event.controller;

import jdk.jfr.Event;
import jdk.jfr.Label;

@Label("RestController Invocation Event")
public class RestControllerInvocationEvent extends Event {
    @Label("Method Name")
    private final String methodName;
    @Label("Method")
    private final String method;
    @Label("URL")
    private final String url;
    @Label("Exception")
    private String exception;

    public RestControllerInvocationEvent(
            String methodName,
            String method,
            String url
    ) {
        this.methodName = methodName;
        this.method = method;
        this.url = url;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
