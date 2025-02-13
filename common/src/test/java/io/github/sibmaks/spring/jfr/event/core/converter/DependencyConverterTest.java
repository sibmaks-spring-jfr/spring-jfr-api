package io.github.sibmaks.spring.jfr.event.core.converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author sibmaks
 * @since 0.0.15
 */
class DependencyConverterTest {

    public static Stream<Arguments> convertArrayToLineCases() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new String[0], null),
                Arguments.of(new String[]{"hello"}, "1\n5 hello"),
                Arguments.of(new String[]{"hello", "everybody"}, "2\n5 hello\n9 everybody")
        );
    }

    public static Stream<Arguments> convertLineToArrayCases() {
        return Stream.of(
                Arguments.of(null, new String[0]),
                Arguments.of("1\n5 hello", new String[]{"hello"}),
                Arguments.of("2\n5 hello\n9 everybody", new String[]{"hello", "everybody"})
        );
    }

    @ParameterizedTest
    @MethodSource("convertArrayToLineCases")
    void convertArrayToLine(String[] dependencies, String expected) {
        assertEquals(expected, DependencyConverter.convert(dependencies));
    }

    @ParameterizedTest
    @MethodSource("convertLineToArrayCases")
    void convertLineToArray(String dependencies, String[] expected) {
        assertArrayEquals(expected, DependencyConverter.convert(dependencies));
    }

}