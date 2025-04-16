package io.github.sibmaks.spring.jfr.event.recording.async;

import io.github.sibmaks.spring.jfr.event.api.async.AsyncMethodCalledFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import jdk.jfr.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Category(Categories.ASYNC)
@Label("Async Method Called Event")
public class AsyncMethodCalledEvent extends Event implements AsyncMethodCalledFact {
    private final String contextId;
    private final String correlationId;
    private final String invocationId;
    private final String className;
    private final String methodName;
}
