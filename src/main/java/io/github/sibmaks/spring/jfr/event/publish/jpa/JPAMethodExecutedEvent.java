package io.github.sibmaks.spring.jfr.event.publish.jpa;

import io.github.sibmaks.spring.jfr.event.api.jpa.JPAMethodExecutedFact;
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
@Category(Categories.JPA)
@Label("JPA Method Executed Event")
public class JPAMethodExecutedEvent extends Event implements JPAMethodExecutedFact {
    private final String invocationId;
}
