package io.github.sibmaks.spring.jfr.event.api.bean;

import io.github.sibmaks.spring.jfr.event.core.converter.DependencyConverter;
import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.9
 */
public interface BeanDefinitionRegisteredFact {
    @Name("contextId")
    @Label("Spring Context Id")
    String getContextId();

    @Name("scope")
    @Label("Bean scope")
    String getScope();

    @Name("beanClassName")
    @Label("Bean class name")
    String getBeanClassName();

    @Name("beanName")
    @Label("Bean name")
    String getBeanName();

    @Name("primary")
    @Label("Bean primary flag")
    String getPrimary();

    @Name("dependencies")
    @Label("Bean's dependencies")
    String getDependencies();

    @Name("generated")
    @Label("Bean generated flag")
    boolean isGenerated();

    default String[] getDependenciesAsArray() {
        return DependencyConverter.convert(getDependencies());
    }
}
