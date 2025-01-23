package io.github.sibmaks.spring.jfr.event.publish.bean;

import io.github.sibmaks.spring.jfr.event.api.bean.MergedBeanDefinitionRegisteredFact;
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
 * @since 0.0.12
 */
@Getter
@Builder
@AllArgsConstructor
@StackTrace(false)
@Category(Categories.BEAN)
@Label("Merged Bean Definition Registered")
public class MergedBeanDefinitionRegisteredEvent extends Event implements MergedBeanDefinitionRegisteredFact {
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
