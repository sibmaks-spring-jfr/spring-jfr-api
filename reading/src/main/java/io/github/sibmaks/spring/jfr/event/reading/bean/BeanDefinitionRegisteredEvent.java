package io.github.sibmaks.spring.jfr.event.reading.bean;

import io.github.sibmaks.spring.jfr.event.api.bean.BeanDefinitionRegisteredFact;
import io.github.sibmaks.spring.jfr.event.reading.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface BeanDefinitionRegisteredEvent extends BeanDefinitionRegisteredFact, RecordedData {
}
