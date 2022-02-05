package se.omegapoint.kompetensdag.workshop.validation.solutions.model2;

import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NameTest {

    @ParameterizedTest
    @MethodSource
    void should_be_valid(final List<String> names) {
        final Validation<String, List<Name>> result = Name.validateMultiple(names);

        assertTrue(result.isValid(), result::getError);
    }

    @ParameterizedTest
    @MethodSource
    void should_be_invalid(final List<String> names) {
        final Validation<String, List<Name>> result = Name.validateMultiple(names);

        assertTrue(result.isInvalid());
        System.out.println(result.getError());
    }

    public static Stream<Arguments> should_be_valid() {
        return Stream.of(
                Arguments.of(Arrays.asList("Ronaldo", "Lionel Messi", "Carl XVI Gustaf")),
                Arguments.of(emptyList())
        );
    }

    public static Stream<Arguments> should_be_invalid() {
        return Stream.of(
                Arguments.of(Arrays.asList("Ronaldo", "Lionel Messi", "Carl XVI Gustaf", "1234")),
                Arguments.of(Collections.singletonList("")),
                Arguments.of(Arrays.asList("Ronaldo", "åäö")),
                Arguments.of(Arrays.asList("Lionel Messi", StringUtils.repeat("a", 160))),
                Arguments.of(Arrays.asList("Lionel Messi", null))
        );
    }

}