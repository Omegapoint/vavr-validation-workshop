package se.omegapoint.kompetensdag.workshop.validation.presentation.example5;

import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Objects;

public class Person {
    public final Name name;
    public final Age age;

    private Person(final Name name, final Age age) {
        this.name = name;
        this.age = age;
    }
    
    public static Validation<String, List<Person>> validateMultiple(final List<Pair<String, Integer>> inputModels) {
        // TODO: 2022-02-10 Implement at presentation 
        return null;
    }

    private static Validation<String, Person> validate(final String name, final int age) {
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
