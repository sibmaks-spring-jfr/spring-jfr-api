package io.github.sibmaks.spring.jfr.event.bean;

import io.github.sibmaks.spring.jfr.event.converter.DependencyConverter;
import jdk.jfr.*;
import lombok.Builder;
import lombok.Getter;

/**
 * @author sibmaks
 * @since 0.0.1
 */
@Getter
@StackTrace(false)
@Category("Spring Beans Flight Recorder")
@Label("Bean Definition Registered")
public class BeanDefinitionRegisteredEvent extends Event {
    @Label("Bean scope")
    private final String scope;
    @Label("Bean class name")
    private final String beanClassName;
    @Label("Bean name")
    private final String beanName;
    @Label("Bean primary flag")
    private final boolean primary;
    @Label("Bean's dependencies")
    private final String dependencies;

    @Builder
    public BeanDefinitionRegisteredEvent(
            String scope,
            String beanClassName,
            String beanName,
            boolean primary,
            String[] dependencies
    ) {
        this.scope = scope;
        this.beanClassName = beanClassName;
        this.beanName = beanName;
        this.primary = primary;
        this.dependencies = DependencyConverter.convert(dependencies);
    }

    /**
     * @return get bean's dependencies
     */
    public String[] getDependencies() {
        return DependencyConverter.convert(dependencies);
    }

}
