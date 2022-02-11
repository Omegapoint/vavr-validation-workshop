package se.omegapoint.kompetensdag.workshop.validation.tasks.model4;

import org.junit.jupiter.api.Test;
import se.omegapoint.kompetensdag.workshop.validation.tasks.model4.input.AccountInformation;
import se.omegapoint.kompetensdag.workshop.validation.tasks.model4.input.Customer;
import se.omegapoint.kompetensdag.workshop.validation.tasks.model4.input.Pet;
import se.omegapoint.kompetensdag.workshop.validation.tasks.model4.input.PetDaycareCenter;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PetDaycareCenterTest {

    @Test
    public void should_be_valid() {
        final PetDaycareCenter input = invalidInputModel();

        assertDoesNotThrow(() -> mapToDomain(input));
    }

    private se.omegapoint.kompetensdag.workshop.validation.tasks.model4.PetDaycareCenter mapToDomain(final PetDaycareCenter input) {
        return new se.omegapoint.kompetensdag.workshop.validation.tasks.model4.PetDaycareCenter(
                input.organizationalNumber,
                input.name,
                input.customers.stream()
                        .map(customer -> new se.omegapoint.kompetensdag.workshop.validation.tasks.model4.Customer(
                                customer.name,
                                new se.omegapoint.kompetensdag.workshop.validation.tasks.model4.AccountInformation(
                                        customer.accountInformation.bankName,
                                        customer.accountInformation.accountNumber,
                                        customer.accountInformation.clearingNumber
                                ),
                                customer.pets.stream()
                                        .map(pet -> new se.omegapoint.kompetensdag.workshop.validation.tasks.model4.Pet(
                                                pet.name,
                                                pet.petType
                                        ))
                                        .collect(Collectors.toList())
                        ))
                        .collect(Collectors.toList())
        );
    }

    private PetDaycareCenter invalidInputModel() {
        return new PetDaycareCenter(
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