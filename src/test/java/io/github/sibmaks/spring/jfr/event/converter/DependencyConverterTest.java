package io.github.sibmaks.spring.jfr.event.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sibmaks
 * @since 0.0.4
 */
class DependencyConverterTest {

    @Test
    void convertToStringAndBack() {
        var values = new String[]{"hello", "", "\n", " world "};
        var converted2String = DependencyConverter.convert(values);
        assertNotNull(converted2String);
        System.out.println(converted2String);

        var converted2Array = DependencyConverter.convert(converted2String);
        assertArrayEquals(values, converted2Array);
    }
}