package io.github.sibmaks.spring.jfr.event.api.bean;

import io.github.sibmaks.spring.jfr.event.core.converter.ArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

/**
 * @author sibmaks
 * @since 0.0.21
 */
@ExtendWith(MockitoExtension.class)
class BeanDefinitionRegisteredFactTest {
    @Mock
    private BeanDefinitionRegisteredFact fact;

    @Test
    void testGetDependencies() {
        var dependencies = UUID.randomUUID().toString();
        when(fact.getDependencies())
                .thenReturn(dependencies);

        var dependencyArray = new String[]{
                UUID.randomUUID().toString(),
        };
        try (var dependencyConverterUtils = mockStatic(ArrayConverter.class)) {
            dependencyConverterUtils.when(() ->
                    ArrayConverter.convert(dependencies)
            ).thenReturn(dependencyArray);

            when(fact.getDependenciesAsArray())
                    .thenCallRealMethod();

            var actual = fact.getDependenciesAsArray();
            assertArrayEquals(dependencyArray, actual);
        }
    }

    @ParameterizedTest
    @EnumSource(Stereotype.class)
    void testGetStereotype(Stereotype stereotype) {
        when(fact.getStereotype())
                .thenReturn(stereotype.name());

        when(fact.getStereotypeAsEnum())
                .thenCallRealMethod();

        var actual = fact.getStereotypeAsEnum();
        assertEquals(stereotype, actual);
    }
}