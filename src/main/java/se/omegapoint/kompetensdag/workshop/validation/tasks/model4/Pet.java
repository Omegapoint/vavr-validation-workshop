package se.omegapoint.kompetensdag.workshop.validation.tasks.model4;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.matchesPattern;
import static org.apache.commons.lang3.Validate.notBlank;

public class Pet {
    public final String name;
    public final PetType petType;

    public Pet(final String name, final String petType) {
        notBlank(name, "name can't be blank");
        isTrue(name.length() <= 100, "name can't be longer than 100 characters");
        matchesPattern(name, "^[a-zA-Z]+( [a-zA-Z]+)*$", "name contains illegal characters");

        notBlank(petType, "petType can't be blank");
         
        this.name = name;
        this.petType = PetType.valueOf(petType.toUpperCase());
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
