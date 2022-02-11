package se.omegapoint.kompetensdag.workshop.validation.presentation.example3;

import io.vavr.control.Validation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {
    @Test
    void should_be_valid() {
        final Validation<String, Person> result = Person.validate("", -1);
        
        assertTrue(result.isValid(), result::getError);
    }
}