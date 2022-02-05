package se.omegapoint.kompetensdag.workshop.validation.solutions.model1;

import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model1.Person;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {

    @ParameterizedTest
    @MethodSource
    void should_be_valid(final String name, final int age) {
        final Validation<String, Person> result = Person.validate(name, age);

        assertTrue(result.isValid(), result::getError);
    }

    @ParameterizedTest
    @MethodSource
    void should_be_invalid(final String name, final int age) {
        final Validation<String, Person> result = Person.validate(name, age);
        
        assertTrue(result.isInvalid());
        System.out.println(result.getError());
    }

    public static Stream<Arguments> should_be_valid() {
        return Stream.of(
                Arguments.of("Ronaldo", 35),
                Arguments.of("Lionel Messi", 33),
                Arguments.of("Carl XVI Gustaf", 75)
        );
    }

    public static Stream<Arguments> should_be_invalid() {
        return Stream.of(
                Arguments.of("", 35),
                Arguments.of("1234", 33),
                Arguments.of("Carl XVI Gustaf", -1),
                Arguments.of("Carl XVI Gustaf", 200),
                Arguments.of(StringUtils.repeat("a", 200), 200),
                Arguments.of("", -1),
                Arguments.of("åäö", 33)
        );
    }
}