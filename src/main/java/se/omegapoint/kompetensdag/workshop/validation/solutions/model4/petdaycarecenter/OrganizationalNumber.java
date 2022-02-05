package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.petdaycarecenter;

import io.vavr.control.Validation;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.ValidationUtils;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;

public class OrganizationalNumber {
    public final String value;

    public OrganizationalNumber(final String value) {
        this.value = value;
    }

    public static Validation<String, OrganizationalNumber> validate(final String organizationalNumber) {
        return ValidationUtils.notBlank(organizationalNumber, "organizationalNumber")
                .flatMap(orgNum -> ValidationUtils.exactLength(orgNum, "organizationalNumber", 10))
                .flatMap(orgNum -> ValidationUtils.matchesPattern(orgNum, "organizationalNumber", "^[\\da-zA-Z]{10}$"))
                .map(OrganizationalNumber::new);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final OrganizationalNumber that = (OrganizationalNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
