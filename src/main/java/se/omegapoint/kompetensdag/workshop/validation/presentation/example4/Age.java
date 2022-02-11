package se.omegapoint.kompetensdag.workshop.validation.presentation.example4;

import io.vavr.control.Validation;

import java.util.Objects;

public class Age {
    private final int value;

    private Age(final int value) {
        this.value = value;
    }

    protected static Validation<String, Age> validate(final int age) {
        return 0 <= age && age <= 150
                ? Validation.valid(new Age(age))
                : Validation.invalid("age must be between 0 and 150");
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Age age = (Age) o;
        return value == age.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
