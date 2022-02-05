package se.omegapoint.kompetensdag.workshop.validation.tasks.model3;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PersonTest {

    @Test
    void should_be_valid() {
        assertDoesNotThrow(() -> input().people.stream()
                .map(pair -> new Person(pair.getLeft(), pair.getRight()))
                .collect(Collectors.toList()));
    }

    private InputModel input() {
        return new InputModel(
                Arrays.asList(
                        Pair.of("1234", 12),
                        Pair.of("", 200),
                        Pair.of("Valid Name", -1)
                )
        );
    }
}