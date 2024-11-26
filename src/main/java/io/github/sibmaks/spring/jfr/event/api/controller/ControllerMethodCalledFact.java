package io.github.sibmaks.spring.jfr.event.api.controller;

import io.github.sibmaks.spring.jfr.event.api.common.InvocationCalledFact;
import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public interface ControllerMethodCalledFact extends InvocationCalledFact {

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
