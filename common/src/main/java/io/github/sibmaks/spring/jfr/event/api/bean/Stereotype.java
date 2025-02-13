package io.github.sibmaks.spring.jfr.event.api.bean;

/**
 * @author sibmaks
 * @since 0.0.12
 */
public enum Stereotype {
    /**
     * Unable to define bean type.
     */
    UNKNOWN,
    /**
     * Bean is a Spring component.
     */
    COMPONENT,
    /**
     * Bean is a Spring controller.
     */
    CONTROLLER,
    /**
     * Bean is a Spring rest controller.
     */
    REST_CONTROLLER,
    /**
     * Bean is a Spring service.
     */
    SERVICE,
    /**
     * Bean is a Spring repository.
     */
    REPOSITORY
}
