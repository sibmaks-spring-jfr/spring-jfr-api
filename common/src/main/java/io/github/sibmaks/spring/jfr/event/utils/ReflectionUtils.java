package io.github.sibmaks.spring.jfr.event.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sibmaks
 * @since 0.0.9
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReflectionUtils {

    public static <T> List<Class<?>> getInterfaces(Class<T> type) {
        if (type == null) {
            return List.of();
        }
        var interfaces = new ArrayList<Class<?>>();
        if (type.isInterface()) {
            interfaces.add(type);
        }
        var typeInterfaces = type.getInterfaces();
        addUnique(Arrays.asList(typeInterfaces), interfaces);
        var superInterfaces = getInterfaces(type.getSuperclass());
        addUnique(superInterfaces, interfaces);
        for (var interfaceType : typeInterfaces) {
            var parentInterfaces = getInterfaces(interfaceType);
            addUnique(parentInterfaces, interfaces);
        }
        return interfaces;
    }

    private static void addUnique(List<Class<?>> superInterfaces, ArrayList<Class<?>> interfaces) {
        for (var anInterface : superInterfaces) {
            if (!interfaces.contains(anInterface)) {
                interfaces.add(anInterface);
            }
        }
    }

    public static Set<Method> getMethods(Class<?> type) {
        if (type == null) {
            return Set.of();
        }
        var methods = new HashSet<Method>();
        methods.addAll(List.of(type.getDeclaredMethods()));
        methods.addAll(List.of(type.getMethods()));
        methods.addAll(getMethods(type.getSuperclass()));
        for (var interfaceType : type.getInterfaces()) {
            methods.addAll(getMethods(interfaceType));
        }
        return methods;
    }

    public static Map<String, List<Method>> getMethodsOverloads(Class<?> type) {
        return getMethods(type)
                .stream()
                .collect(Collectors.groupingBy(Method::getName));
    }

    public static Method getOverload(
            Map<String, List<Method>> methods,
            Method method
    ) {
        var overloads = methods.get(method.getName());
        if (overloads == null) {
            return null;
        }
        var methodParameters = method.getParameters();
        return overloads.stream()
                .filter(it -> Arrays.equals(it.getParameters(), methodParameters))
                .findFirst()
                .orElse(null);
    }
}
