package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.pet;

import java.util.Objects;

public class Pet {
    public final Name name;
    public final PetType petType;

    private Pet(final Name name, final PetType petType) {
        this.name = name;
        this.petType = petType;
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
