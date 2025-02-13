package io.github.sibmaks.spring.jfr.event.recording.controller;

import io.github.sibmaks.spring.jfr.event.api.controller.ControllerMethodCalledFact;
import io.github.sibmaks.spring.jfr.event.constant.Categories;
import io.github.sibmaks.spring.jfr.event.reading.core.recorded.RecordedEventType;
import io.github.sibmaks.spring.jfr.event.reading.api.controller.ControllerMethodCalledRecordedEvent;
import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@StackTrace
@Category(Categories.CONTROLLER)
@Label("Controller Method Called Event")
@RecordedEventType(ControllerMethodCalledRecordedEvent.class)
public class ControllerMethodCalledEvent extends Event implements ControllerMethodCalledFact {
    private final String contextId;
    private final String invocationId;
    private final String className;
    private final String methodName;
    private final String httpMethod;
    private final String url;
    private final boolean rest;
}
