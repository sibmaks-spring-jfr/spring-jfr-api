package io.github.sibmaks.spring.jfr.event.recording.bean;

import io.github.sibmaks.spring.jfr.event.api.bean.PostProcessAfterInitializationFact;
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
@Label("Post Process After Initialization Invoked")
public class PostProcessAfterInitializationEvent extends Event implements PostProcessAfterInitializationFact {
    private final String contextId;
    private final String beanName;
}
