package se.omegapoint.kompetensdag.workshop.validation.presentation.example2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PersonTest {
    
    @Test
    void should_be_valid() {
        assertDoesNotThrow(() -> new Person("", -1));
    }

}