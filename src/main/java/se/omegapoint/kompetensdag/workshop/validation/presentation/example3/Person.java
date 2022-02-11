package se.omegapoint.kompetensdag.workshop.validation.presentation.example3;

import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Person {
    public final String name;
    public final int age;

    private Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public static Validation<String, Person> validate(final String name, final int age) {
        // TODO: 2022-02-10 Implement at presentation  
        return null;
    }

    private static Validation<String, String> validateName(final String name) {
        return validateNotBlank(name)
                .flatMap(Person::validateLength)
                .flatMap(Person::validateLegalCharacters);
    }

    private static Validation<String, Integer> validateAge(final int age) {
        return 0 <= age && age <= 150
                ? Validation.valid(age)
                : Validation.invalid("age must be between 0 and 150");
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
        final Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
