package io.github.sibmaks.spring.jfr.event.bean;

import jdk.jfr.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author sibmaks
 * @since 0.0.1
 */
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Category("Spring Beans Flight Recorder")
@Name("io.github.sibmaks.spring.jfr.event.bean.BeanDefinitionRegisteredEvent")
@Label("Bean Definition Registered")
public class BeanDefinitionRegisteredEvent extends Event {
    @Label("Bean name")
    private final String beanName;
    @Label("Bean's dependencies")
    private final String dependencies;
}
