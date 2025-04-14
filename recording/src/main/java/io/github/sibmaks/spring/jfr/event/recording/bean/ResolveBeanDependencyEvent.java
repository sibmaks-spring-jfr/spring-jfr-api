package io.github.sibmaks.spring.jfr.event.recording.bean;

import io.github.sibmaks.spring.jfr.event.api.bean.ResolveBeanDependencyFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author sibmaks
 * @since 0.0.14
 */
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Category(Categories.BEAN)
@Label("Resolve Bean Dependency")
public class ResolveBeanDependencyEvent extends Event implements ResolveBeanDependencyFact {
    private final String contextId;
    private final String dependentBeanName;
    private final String dependencyBeanName;
}
