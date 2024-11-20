package io.github.sibmaks.spring.jfr.event.api.async;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public interface AsyncMethodFailedFact {
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
