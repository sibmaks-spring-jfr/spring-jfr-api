package io.github.sibmaks.spring.jfr.event.api.bean;

import jdk.jfr.Label;
import jdk.jfr.Name;

/**
 * @author sibmaks
 * @since 0.0.11
 */
public interface PostProcessBeforeDestructionFact {
    @Name("contextId")
    @Label("Spring Context Id")
    String getContextId();

    @Name("beanName")
    @Label("Bean name")
    String getBeanName();
}
