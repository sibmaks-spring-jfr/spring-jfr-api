package io.github.sibmaks.spring.jfr.event.jpa;

import io.github.sibmaks.spring.jfr.event.constant.Constants;
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
@Category(Constants.CATEGORY_JPA)
@Label("JPA Invocation Event")
public class JPAMethodInvokedEvent extends Event {
    @Label("Correlation Id")
    private final String correlationId;
    @Label("Invocation Id")
    private final String invocationId;
    @Label("Class Name")
    private final String className;
    @Label("Method Name")
    private final String methodName;
}
