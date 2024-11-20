package io.github.sibmaks.spring.jfr.event.publish.bean;

import io.github.sibmaks.spring.jfr.event.api.bean.PostProcessBeforeInitializationFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
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
@Category(Categories.BEAN)
@Label("Post Process Before Initialization Invoked")
public class PostProcessBeforeInitializationEvent extends Event implements PostProcessBeforeInitializationFact {
    private final String contextId;
    private final String beanName;
}