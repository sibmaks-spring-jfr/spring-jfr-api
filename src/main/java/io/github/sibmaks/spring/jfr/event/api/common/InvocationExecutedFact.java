package io.github.sibmaks.spring.jfr.event.api.common;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public interface InvocationExecutedFact {
    @Name("invocationId")
    @Label("Invocation Id")
    String getInvocationId();
}
