package io.github.sibmaks.spring.jfr.event.api.component;

import io.github.sibmaks.spring.jfr.event.api.common.InvocationCalledFact;
import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.10
 */
public interface ComponentMethodCalledFact extends InvocationCalledFact {

    @Name("correlationId")
    @Label("Correlation Id")
    String getCorrelationId();

}
