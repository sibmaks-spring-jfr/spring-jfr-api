package io.github.sibmaks.spring.jfr.event.api.bean;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 *
 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory#doResolveDependency
 * @author sibmaks
 * @since 0.0.14
 */
public interface ResolveBeanDependencyFact {
    @Name("contextId")
    @Label("Spring Context Id")
    String getContextId();

    @Name("dependentBeanName")
    @Label("Dependent Bean Name")
    String getDependentBeanName();

    @Name("dependencyBeanName")
    @Label("Dependency Bean Name")
    String getDependencyBeanName();
}
