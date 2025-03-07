package io.github.sibmaks.spring.jfr.event.reading.core;

/**
 * Custom exception for conversion errors.
 *
 * @author sibmaks
 * @since 0.0.21
 */
public class ConversionException extends RuntimeException {
    public ConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}