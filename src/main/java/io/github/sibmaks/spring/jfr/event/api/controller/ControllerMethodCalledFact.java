package io.github.sibmaks.spring.jfr.event.api.controller;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public interface ControllerMethodCalledFact {
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

    @Name("httpMethod")
    @Label("HTTP Method")
    String getHttpMethod();

    @Name("url")
    @Label("URL")
    String getUrl();

    @Name("rest")
    @Label("Rest Flag")
    boolean isRest();
}
