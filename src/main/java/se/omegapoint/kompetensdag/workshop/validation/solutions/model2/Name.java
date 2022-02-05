package se.omegapoint.kompetensdag.workshop.validation.solutions.model2;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

public class Name {
    public final String value;

    private Name(final String value) {
        this.value = value;
    }

    public static Validation<String, List<Name>> validateMultiple(final List<String> names) {
        return Validation.traverse(
                        names,
                        name -> validate(name)
                                .mapError(io.vavr.collection.List::of)
                )
                .map(Seq::asJava)
                .mapError(errorMessages -> StringUtils.join(errorMessages, ",\n"));
    }

    public static Validation<String, Name> validate(final String name) {
        return validateNotBlank(name)
                .flatMap(Name::validateLength)
                .flatMap(Name::validateLegalCharacters)
                .map(Name::new);
    }

    private static Validation<String, String> validateLegalCharacters(final String name) {
        return name.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")
                ? Validation.valid(name)
                : Validation.invalid("name contains illegal characters");
    }

    private static Validation<String, String> validateLength(final String name) {
        return name.length() > 150
                ? Validation.invalid("name can't be longer than 150 characters")
                : Validation.valid(name);
    }

    private static Validation<String, String> validateNotBlank(final String name) {
        return StringUtils.isBlank(name)
                ? Validation.invalid("name can't be blank")
                : Validation.valid(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
