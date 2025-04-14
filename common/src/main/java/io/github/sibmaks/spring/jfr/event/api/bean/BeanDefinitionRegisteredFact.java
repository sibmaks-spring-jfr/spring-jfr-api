package io.github.sibmaks.spring.jfr.event.api.bean;

import io.github.sibmaks.spring.jfr.event.core.converter.ArrayConverter;
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

    /**
     * Bean class name from BeanDefinition, can be different from actual bean class name
     *
     * @return runtime class name
     */
    @Name("actualBeanClassName")
    @Label("Bean class name")
    String getActualBeanClassName();

    /**
     * Source bean class name
     *
     * @return source bean class name
     */
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

    @Name("stereotype")
    @Label("Bean's stereotype")
    String getStereotype();

    /**
     * Get dependencies as array
     *
     * @return dependency array
     */
    default String[] getDependenciesAsArray() {
        var dependencies = getDependencies();
        return ArrayConverter.convert(dependencies);
    }

    /**
     * Get stereotype as enum
     *
     * @return stereotype
     */
    default Stereotype getStereotypeAsEnum() {
        var stereotype = getStereotype();
        return Stereotype.valueOf(stereotype);
    }
}
