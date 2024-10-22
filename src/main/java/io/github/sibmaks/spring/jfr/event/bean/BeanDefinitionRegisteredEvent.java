package io.github.sibmaks.spring.jfr.event.bean;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author sibmaks
 * @since 0.0.1
 */
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Name("io.github.sibmaks.spring.jfr.event.bean.BeanDefinitionRegisteredEvent")
@Label("Bean Definition Registered")
public class BeanDefinitionRegisteredEvent extends Event {
    @Label("Bean name")
    private final String beanName;
    @Label("Bean's dependencies")
    private final List<String> dependencies;
}
