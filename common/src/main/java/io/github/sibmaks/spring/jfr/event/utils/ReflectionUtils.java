package io.github.sibmaks.spring.jfr.event.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sibmaks
 * @since 0.0.9
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReflectionUtils {

    public static <T> Set<Class<?>> getInterfaces(Class<T> type) {
        if (type == null) {
            return Set.of();
        }
        var interfaces = new HashSet<Class<?>>();
        if (type.isInterface()) {
            interfaces.add(type);
        }
        interfaces.addAll(List.of(type.getInterfaces()));
        interfaces.addAll(getInterfaces(type.getSuperclass()));
        return interfaces;
    }

    public static Set<Method> getMethods(Class<?> type) {
        if (type == null) {
            return Set.of();
        }
        var methods = new HashSet<Method>();
        methods.addAll(List.of(type.getDeclaredMethods()));
        methods.addAll(List.of(type.getMethods()));
        methods.addAll(getMethods(type.getSuperclass()));
        return methods;
    }

}
