package io.github.sibmaks.spring.jfr.event.api.controller;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public interface ControllerMethodFailedFact {
    @Name("invocationId")
    @Label("Invocation Id")
    String getInvocationId();

    @Name("exceptionClass")
    @Label("Exception Class")
    String getExceptionClass();

    @Name("exceptionMessage")
    @Label("Exception Message")
    String getExceptionMessage();
}
