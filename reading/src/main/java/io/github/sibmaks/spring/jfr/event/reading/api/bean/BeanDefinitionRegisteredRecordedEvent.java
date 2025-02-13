package io.github.sibmaks.spring.jfr.event.reading.api.bean;

import io.github.sibmaks.spring.jfr.event.api.bean.BeanDefinitionRegisteredFact;
import io.github.sibmaks.spring.jfr.event.reading.api.RecordedData;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface BeanDefinitionRegisteredRecordedEvent extends BeanDefinitionRegisteredFact, RecordedData {
}
