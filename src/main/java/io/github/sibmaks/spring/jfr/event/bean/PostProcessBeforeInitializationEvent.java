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
@Label("Post Process Before Initialization Invoked")
public class PostProcessBeforeInitializationEvent extends Event {
    @Label("Bean name")
    private final String beanName;
}
