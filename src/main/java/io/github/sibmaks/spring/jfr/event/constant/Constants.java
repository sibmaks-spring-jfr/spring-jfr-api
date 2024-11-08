package io.github.sibmaks.spring.jfr.event.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author sibmaks
 * @since 0.0.9
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
    public static final String CATEGORY_CONTROLLER = "Spring Controller Flight Recorder";
    public static final String CATEGORY_BEAN = "Spring Beans Flight Recorder";
    public static final String CATEGORY_SCHEDULED = "Spring Scheduled Flight Recorder";
    public static final String CATEGORY_JPA = "Spring JPA Flight Recorder";
}
