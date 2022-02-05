package se.omegapoint.kompetensdag.workshop.validation.tasks.model2;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NameTest {
    @Test
    void should_be_valid() {
        assertDoesNotThrow(() -> Stream.of("1234", "", "åäö", "Valid Name")
                .map(Name::new)
                .collect(Collectors.toList()));
    }
}