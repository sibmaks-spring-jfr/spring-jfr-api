package io.github.sibmaks.spring.jfr.event.bean;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;
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
@Name("io.github.sibmaks.spring.jfr.event.bean.PostProcessBeforeInitializationEvent")
@Label("Post Process Before Initialization Invoked")
public class PostProcessBeforeInitializationEvent extends Event {
    @Label("Bean name")
    private final String beanName;
}
