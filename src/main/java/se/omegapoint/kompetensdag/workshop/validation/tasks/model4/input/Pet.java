package se.omegapoint.kompetensdag.workshop.validation.tasks.model4.input;

import java.util.Objects;

public class Pet {
    public final String name;
    public final String petType;

    public Pet(final String name, final String petType) {
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
