package io.github.sibmaks.spring.jfr.event.utils;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author sibmaks
 * @since 0.0.15
 */
class ReflectionUtilsTest {

    @Test
    void getInterfaces() {
        var interfaces = ReflectionUtils.getInterfaces(TestClass.class);
        assertEquals(2, interfaces.size());
        assertTrue(interfaces.contains(Callable.class));
        assertTrue(interfaces.contains(Runnable.class));
    }

    @Test
    void getObjectInterfaces() {
        var interfaces = ReflectionUtils.getInterfaces(Object.class);
        assertEquals(0, interfaces.size());
    }

    @Test
    void getParentInterfaces() {
        var interfaces = ReflectionUtils.getInterfaces(ParentTestClass.class);
        assertTrue(interfaces.contains(Callable.class));
        assertEquals(1, interfaces.size());
    }

    @Test
    void getInterfaceInterfaces() {
        var interfaces = ReflectionUtils.getInterfaces(Callable.class);
        assertTrue(interfaces.contains(Callable.class));
        assertEquals(1, interfaces.size());
    }

    @Test
    void getChildInterfaceInterfaces() {
        var interfaces = ReflectionUtils.getInterfaces(ChildInterface.class);
        assertTrue(interfaces.contains(ChildInterface.class));
        assertTrue(interfaces.contains(Callable.class));
        assertEquals(2, interfaces.size());
    }

    @Test
    void getMethods() throws NoSuchMethodException {
        var methods = ReflectionUtils.getMethods(TestClass.class);
        assertTrue(methods.contains(TestClass.class.getDeclaredMethod("run")));
        assertTrue(methods.contains(ParentTestClass.class.getDeclaredMethod("call")));
    }

    @Test
    void getInterfaceMethods() throws NoSuchMethodException {
        var methods = ReflectionUtils.getMethods(Callable.class);
        assertTrue(methods.contains(Callable.class.getDeclaredMethod("call")));
    }

    interface ChildInterface extends Callable {

    }

    static class ParentTestClass implements Callable {

        @Override
        public Object call() {
            return null;
        }
    }

    static class TestClass extends ParentTestClass implements Runnable {

        @Override
        public void run() {

        }
    }
}