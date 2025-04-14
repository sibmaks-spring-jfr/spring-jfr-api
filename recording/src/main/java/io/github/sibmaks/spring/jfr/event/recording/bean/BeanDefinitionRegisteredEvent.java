package io.github.sibmaks.spring.jfr.event.recording.bean;

import io.github.sibmaks.spring.jfr.event.api.bean.BeanDefinitionRegisteredFact;
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
 * @since 0.0.1
 */
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Category(Categories.BEAN)
@Label("Bean Definition Registered")
public class BeanDefinitionRegisteredEvent extends Event implements BeanDefinitionRegisteredFact {
    private final String contextId;
    private final String scope;
    private final String actualBeanClassName;
    private final String beanClassName;
    private final String beanName;
    private final String primary;
    private final String dependencies;
    private final String stereotype;
    private final boolean generated;
}
