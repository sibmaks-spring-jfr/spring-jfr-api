package io.github.sibmaks.spring.jfr.event.api.tracing.common;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public interface InvocationCalledFact {
    @Name("contextId")
    @Label("Spring Context Id")
    String getContextId();

    @Name("invocationId")
    @Label("Invocation Id")
    String getInvocationId();

    @Name("className")
    @Label("Class Name")
    String getClassName();

    @Name("methodName")
    @Label("Method Name")
    String getMethodName();
}
