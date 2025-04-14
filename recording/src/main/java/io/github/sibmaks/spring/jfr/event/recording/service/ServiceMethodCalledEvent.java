package io.github.sibmaks.spring.jfr.event.recording.service;

import io.github.sibmaks.spring.jfr.event.api.service.ServiceMethodCalledFact;
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
@Category(Categories.SERVICE)
@Label("Service Method Invoked Event")

public class ServiceMethodCalledEvent extends Event implements ServiceMethodCalledFact {
    private final String contextId;
    private final String correlationId;
    private final String invocationId;
    private final String className;
    private final String methodName;
}
