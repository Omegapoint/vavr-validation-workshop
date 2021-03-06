package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.customer;

import io.vavr.control.Validation;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.ValidationUtils;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;

public class Name {
    public final String value;

    public Name(final String value) {
        this.value = notBlank(value);
    }

    public static Validation<String, Name> validate(final String name) {
        return ValidationUtils.notBlank(name, "customerName")
                .flatMap(cName -> ValidationUtils.maxLength(cName, "customerName", 100))
                .flatMap(cName -> ValidationUtils.matchesPattern(cName, "customerName", "^[a-zA-Z]+( [a-zA-Z]+)*$"))
                .map(Name::new);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name that = (Name) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
