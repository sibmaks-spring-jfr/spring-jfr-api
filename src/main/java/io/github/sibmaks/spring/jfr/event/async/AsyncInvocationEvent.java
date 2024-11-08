package io.github.sibmaks.spring.jfr.event.async;

import jdk.jfr.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace
@Category("Spring Async Flight Recorder")
@Label("Async Invocation Event")
public class AsyncInvocationEvent extends Event {
    @Label("Class Name")
    private final String className;
    @Label("Method Name")
    private final String methodName;
    @Label("Feature Execution Time")
    private Long featureExecutionTime;
    @Label("Execution Exception")
    private String executionException;
    @Label("Exception")
    private String exception;

    public AsyncInvocationEvent(
            String className,
            String methodName
    ) {
        this.className = className;
        this.methodName = methodName;
    }
}
