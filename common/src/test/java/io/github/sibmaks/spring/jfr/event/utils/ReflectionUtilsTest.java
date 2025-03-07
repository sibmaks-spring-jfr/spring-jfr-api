package io.github.sibmaks.spring.jfr.event.utils;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

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
    void getMethodsOverloads() throws NoSuchMethodException {
        var methods = ReflectionUtils.getMethodsOverloads(TestClass.class);

        var runnable = Runnable.class.getDeclaredMethod("run");
        var testRun = TestClass.class.getDeclaredMethod("run");
        assertEquals(List.of(runnable, testRun), methods.get("run"));

        var testCall = ParentTestClass.class.getDeclaredMethod("call");
        var callable = Callable.class.getDeclaredMethod("call");
        assertEquals(List.of(testCall, callable), methods.get("call"));
    }

    @Test
    void getOverload() throws NoSuchMethodException {
        var methods = ReflectionUtils.getMethodsOverloads(TestClass.class);
        var runnable = Runnable.class.getDeclaredMethod("run");

        var overload = ReflectionUtils.getOverload(methods, runnable);
        assertEquals(runnable, overload);
    }

    @Test
    void getOverloadWhenNoVariants() throws NoSuchMethodException {
        var methods = ReflectionUtils.getMethodsOverloads(ParentTestClass.class);
        var runnable = Runnable.class.getDeclaredMethod("run");

        var overload = ReflectionUtils.getOverload(methods, runnable);
        assertNull(overload);
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