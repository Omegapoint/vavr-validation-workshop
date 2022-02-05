package se.omegapoint.kompetensdag.workshop.validation.tasks.model1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PersonTest {

    @Test
    void should_be_valid() {
        assertDoesNotThrow(() -> new Person("1234", -1));
    }
}