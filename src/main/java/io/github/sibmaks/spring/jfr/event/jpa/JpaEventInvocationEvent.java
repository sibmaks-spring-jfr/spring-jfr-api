package io.github.sibmaks.spring.jfr.event.jpa;

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
@Category("Spring Controller Flight Recorder")
@Name("io.github.sibmaks.spring.jfr.event.jpa.JpaEventInvocationEvent")
@Label("JPA Invocation Event")
public class JpaEventInvocationEvent extends Event {
    @Label("Method Name")
    private final String methodName;

    @Label("Exception")
    private String exception;

    public JpaEventInvocationEvent(String methodName) {
        this.methodName = methodName;
    }

}
