package io.github.sibmaks.spring.jfr.event.publish.jpa;

import io.github.sibmaks.spring.jfr.event.api.common.InvocationExecutedFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Category(Categories.JPA)
@Label("JPA Method Failed Event")
public class JPAMethodFailedEvent extends Event implements InvocationExecutedFact {
    private final String invocationId;
    private final String exceptionClass;
    private final String exceptionMessage;
}
