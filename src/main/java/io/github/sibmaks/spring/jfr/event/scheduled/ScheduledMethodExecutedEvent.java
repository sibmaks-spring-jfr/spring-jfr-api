package io.github.sibmaks.spring.jfr.event.scheduled;

import io.github.sibmaks.spring.jfr.event.constant.Constants;
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
@StackTrace(false)
@Category(Constants.CATEGORY_SCHEDULED)
@Label("Scheduled Method Executed Event")
public class ScheduledMethodExecutedEvent extends Event {
    @Label("Invocation Id")
    private final String invocationId;
}
