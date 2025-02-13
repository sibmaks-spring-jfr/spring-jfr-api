package io.github.sibmaks.spring.jfr.event.reading.core.recorded;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sibmaks
 * @since 0.0.15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RecordedEventType {

    Class<?> value();

}
