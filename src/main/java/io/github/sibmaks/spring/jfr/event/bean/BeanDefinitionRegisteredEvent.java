package io.github.sibmaks.spring.jfr.event.bean;

import io.github.sibmaks.spring.jfr.event.converter.DependencyConverter;
import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;
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
    @Label("Bean name")
    private final String beanName;
    @Label("Bean's dependencies")
    private final String dependencies;

    @Builder
    public BeanDefinitionRegisteredEvent(String beanName, String[] dependencies) {
        this.beanName = beanName;
        this.dependencies = DependencyConverter.convert(dependencies);
    }

    /**
     * @return get bean's dependencies
     */
    public String[] getDependencies() {
        return DependencyConverter.convert(dependencies);
    }

}
