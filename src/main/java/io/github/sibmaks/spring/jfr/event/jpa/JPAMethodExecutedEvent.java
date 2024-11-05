package io.github.sibmaks.spring.jfr.event.jpa;

import io.github.sibmaks.spring.jfr.event.constant.Constants;
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
@Category(Constants.CATEGORY_JPA)
@Label("JPA Invocation Event")
public class JPAMethodExecutedEvent extends Event {
    @Label("Correlation Id")
    private final String correlationId;
    @Label("Invocation Id")
    private final String invocationId;
}
