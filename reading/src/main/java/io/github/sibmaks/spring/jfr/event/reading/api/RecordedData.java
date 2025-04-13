package io.github.sibmaks.spring.jfr.event.reading.api;

import jdk.jfr.EventType;
import jdk.jfr.consumer.RecordedStackTrace;
import jdk.jfr.consumer.RecordedThread;

import java.time.Duration;
import java.time.Instant;

/**
 * @author sibmaks
 * @since 0.0.15
 */
public interface RecordedData {
    /**
     * Returns the stack trace that was created when the event was committed, or
     * {@code null} if the event lacks a stack trace.
     *
     * @return stack trace, or {@code null} if doesn't exist for the event
     */
    RecordedStackTrace getStackTrace();

    /**
     * Returns the thread from which the event was committed, or {@code null} if
     * the thread was not recorded.
     *
     * @return thread, or {@code null} if doesn't exist for the event
     */
    RecordedThread getThread();

    /**
     * Returns the event type that describes the event.
     *
     * @return the event type, not {@code null}
     */
    EventType getEventType();

    /**
     * Returns the start time of the event.
     * <p>
     * If the event is an instant event, then the start time and end time are the same.
     * </p>
     *
     * @return the start time, not {@code null}
     */
    Instant getStartTime();

    /**
     * Returns the end time of the event.
     * <p>
     * If the event is an instant event, then the start time and end time are the same.
     * </p>
     *
     * @return the end time, not {@code null}
     */
    Instant getEndTime();

    /**
     * Returns the duration of the event, measured in nanoseconds.
     *
     * @return the duration in nanoseconds, not {@code null}
     */
    Duration getDuration();
}
