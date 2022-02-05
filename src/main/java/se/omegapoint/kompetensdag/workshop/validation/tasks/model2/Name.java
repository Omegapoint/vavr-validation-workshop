package se.omegapoint.kompetensdag.workshop.validation.tasks.model2;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.matchesPattern;
import static org.apache.commons.lang3.Validate.notBlank;

public class Name {
    public final String value;

    public Name(final String value) {
        notBlank(value, "name can't be blank");
        isTrue(value.length() <= 100, "name can't be longer than 100 characters");
        matchesPattern(value, "^[a-zA-Z]+( [a-zA-Z]+)*", "name contains illegal characters");
        this.value = value;
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
