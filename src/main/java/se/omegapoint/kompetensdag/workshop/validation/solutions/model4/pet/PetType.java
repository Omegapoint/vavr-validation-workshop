package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.pet;

import io.vavr.control.Validation;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.ValidationUtils;

import java.util.Arrays;

public enum PetType {
    DOG,
    CAT,
    HORSE,
    RAT,
    SNAKE,
    HAMSTER;

    public static Validation<String, PetType> validate(final String petType) {
        return ValidationUtils.notBlank(petType, "petType")
                .flatMap(notBlankPetType -> Arrays.stream(PetType.values())
                        .filter(pType -> pType.name().equals(notBlankPetType.toUpperCase()))
                        .findFirst()
                        .<Validation<String, PetType>>map(Validation::valid)
                        .orElseGet(() -> Validation.invalid("petType is invalid")));
    }
}
