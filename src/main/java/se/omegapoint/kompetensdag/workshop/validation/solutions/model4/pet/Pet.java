package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.pet;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

public class Pet {
    public final Name name;
    public final PetType petType;

    private Pet(final Name name, final PetType petType) {
        this.name = name;
        this.petType = petType;
    }

    public static Validation<String, List<Pet>> validateMultiple(final List<se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.Pet> pets) {
        return Validation.traverse(
                        pets,
                        pet -> validate(pet)
                                .mapError(io.vavr.collection.List::of)
                )
                .map(Seq::asJava)
                .mapError(errorMessages -> String.format("Pets: [ %s ]", StringUtils.join(errorMessages, ", ")));
    }

    private static Validation<String, Pet> validate(final se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.Pet pet) {
        return Validation.combine(
                        Name.validate(pet.name),
                        PetType.validate(pet.petType)
                )
                .ap(Pet::new)
                .mapError(errorMessages -> String.format("%s", StringUtils.join(errorMessages, ", ")));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Pet pet = (Pet) o;
        return Objects.equals(name, pet.name) && Objects.equals(petType, pet.petType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, petType);
    }
}
