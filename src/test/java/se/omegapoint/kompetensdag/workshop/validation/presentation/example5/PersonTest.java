package se.omegapoint.kompetensdag.workshop.validation.presentation.example5;

import io.vavr.control.Validation;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {
    
    @Test
    void should_be_valid() {
        final Validation<String, List<Person>> result = Person.validateMultiple(
                Arrays.asList(Pair.of("", -1),
                        Pair.of("Test Testsson", 160),
                        Pair.of("1234", 25)));
        
        assertTrue(result.isValid(), result::getError);
    }

}