package se.omegapoint.kompetensdag.workshop.validation.presentation.example4;

import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Person {
    public final Name name;
    public final Age age;

    private Person(final Name name, final Age age) {
        this.name = name;
        this.age = age;
    }

    public static Validation<String, Person> validate(final String name, final int age) {
        return Validation.combine(
                        Name.validate(name),
                        Age.validate(age)
                )
                .ap(Person::new)
                .mapError(errorMessage -> StringUtils.join(errorMessage, ", "));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
