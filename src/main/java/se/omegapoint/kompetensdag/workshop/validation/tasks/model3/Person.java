package se.omegapoint.kompetensdag.workshop.validation.tasks.model3;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.matchesPattern;
import static org.apache.commons.lang3.Validate.notBlank;

public class Person {
    public final String name;
    public final int age;

    public Person(final String name, final int age) {
        notBlank(name, "name can't be blank");
        isTrue(name.length() <= 100, "name can't be longer than 100 characters");
        matchesPattern(name, "^[a-zA-Z]+( [a-zA-Z]+)*", "name contains illegal characters");
        isTrue(0 <= age && age <= 150, "age must be between 0 and 150");
        this.name = name;
        this.age = age;
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
