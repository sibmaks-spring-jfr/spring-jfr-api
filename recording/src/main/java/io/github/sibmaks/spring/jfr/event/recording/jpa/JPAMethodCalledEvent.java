package io.github.sibmaks.spring.jfr.event.recording.jpa;

import io.github.sibmaks.spring.jfr.event.api.jpa.JPAMethodCalledFact;
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
@StackTrace
@Category(Categories.JPA)
@Label("JPA Method Invoked Event")

public class JPAMethodCalledEvent extends Event implements JPAMethodCalledFact {
    private final String contextId;
    private final String correlationId;
    private final String invocationId;
    private final String className;
    private final String methodName;
}
