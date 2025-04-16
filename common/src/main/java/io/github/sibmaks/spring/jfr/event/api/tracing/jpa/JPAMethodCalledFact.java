package io.github.sibmaks.spring.jfr.event.api.tracing.jpa;

import io.github.sibmaks.spring.jfr.event.api.tracing.common.InvocationCalledFact;
import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public interface JPAMethodCalledFact extends InvocationCalledFact {

    @Name("correlationId")
    @Label("Correlation Id")
    String getCorrelationId();

}
