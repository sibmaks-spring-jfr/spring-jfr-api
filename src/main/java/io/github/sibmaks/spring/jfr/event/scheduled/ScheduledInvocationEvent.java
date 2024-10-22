package io.github.sibmaks.spring.jfr.event.scheduled;

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
@Category("Spring Scheduled Flight Recorder")
@Name("io.github.sibmaks.spring.jfr.event.scheduled.ScheduledInvocationEvent")
@Label("Scheduled Task Invocation Event")
public class ScheduledInvocationEvent extends Event {
    @Label("Method Name")
    private final String methodName;

    @Label("Exception")
    private String exception;
}
