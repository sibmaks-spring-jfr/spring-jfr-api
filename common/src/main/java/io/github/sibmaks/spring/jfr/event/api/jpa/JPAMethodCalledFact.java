package io.github.sibmaks.spring.jfr.event.api.jpa;

import io.github.sibmaks.spring.jfr.event.api.common.InvocationCalledFact;
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
