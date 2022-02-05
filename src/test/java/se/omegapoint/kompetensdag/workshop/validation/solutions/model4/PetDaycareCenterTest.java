package se.omegapoint.kompetensdag.workshop.validation.solutions.model4;

import io.vavr.control.Validation;
import org.junit.jupiter.api.Test;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.AccountInformation;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.Customer;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.Pet;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.petdaycarecenter.PetDaycareCenter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PetDaycareCenterTest {
    @Test
    void should_be_valid() {
        final Validation<String, PetDaycareCenter> result = PetDaycareCenter.validate(invalidInputModel());

        assertTrue(result.isValid(), result::getError);
    }

    private se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.PetDaycareCenter invalidInputModel() {
        return new se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.PetDaycareCenter(
                "1234åäö",
                "Daniel's #1 Dog Walking Service",
                Arrays.asList(
                        new Customer(
                                "Daniel Walker",
                                new AccountInformation(
                                        "S3B",
                                        "010570175017ååå",
                                        "12345"
                                ),
                                Arrays.asList(
                                        new Pet(
                                                "Bessy",
                                                "Puppy"
                                        ),
                                        new Pet(
                                                "Betty, the #1 cat",
                                                "HORSE"
                                        )
                                )
                        ),
                        new Customer(
                                "ZugZug SMOrc, Horde Chieftain",
                                new AccountInformation(
                                        "Håndelsbänken",
                                        "snacka med benke",
                                        "070612345678"
                                ),
                                Arrays.asList(
                                        new Pet(
                                                "Killer",
                                                "Pitbull"
                                        ),
                                        new Pet(
                                                "",
                                                "Dog, but it passed away"
                                        )
                                )
                        )
                )
        );
    }
}