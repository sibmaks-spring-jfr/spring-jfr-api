package io.github.sibmaks.spring.jfr.event.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author sibmaks
 * @since 0.0.9
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Categories {
    public static final String ASYNC = "Spring Async Flight Recorder";
    public static final String CONTROLLER = "Spring Controller Flight Recorder";
    public static final String BEAN = "Spring Beans Flight Recorder";
    public static final String SCHEDULED = "Spring Scheduled Flight Recorder";
    public static final String JPA = "Spring JPA Flight Recorder";
    public static final String SERVICE = "Spring Service Flight Recorder";
    public static final String COMPONENT = "Spring Component Flight Recorder";
}
