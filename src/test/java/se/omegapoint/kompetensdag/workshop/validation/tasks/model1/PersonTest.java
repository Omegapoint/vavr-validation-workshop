package se.omegapoint.kompetensdag.workshop.validation.tasks.model1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PersonTest {

    @Test
    public void should_be_valid() {
        assertDoesNotThrow(() -> new Person("1234", -1));
    }
}