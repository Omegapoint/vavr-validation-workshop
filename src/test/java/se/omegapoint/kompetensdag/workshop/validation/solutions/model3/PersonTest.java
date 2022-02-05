package se.omegapoint.kompetensdag.workshop.validation.solutions.model3;

import io.vavr.control.Validation;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {

    public static Stream<Arguments> should_be_valid() {
        return Stream.of(
                Arguments.of(new InputModel(Arrays.asList(Pair.of("Ronaldo", 35), Pair.of("Lionel Messi", 33), Pair.of("Carl XVI Gustaf", 75))))
        );
    }

    @ParameterizedTest
    @MethodSource
    void should_be_valid(final InputModel input) {
        final Validation<String, List<Person>> result = Person.validateMultiple(input.people);

        assertTrue(result.isValid(), result::getError);
    }
}