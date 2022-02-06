package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.accountinformation;

import io.vavr.control.Validation;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.ValidationUtils;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;

public class BankName {
    public final String value;

    private BankName(final String value) {
        this.value = notBlank(value);
    }

    public static Validation<String, BankName> validate(final String bankName) {
        return ValidationUtils.notBlank(bankName, "bankName")
                .flatMap(validName -> ValidationUtils.maxLength(validName, "bankName", 150))
                .flatMap(validName -> ValidationUtils.matchesPattern(validName, "bankName", "^[a-zA-Z]+( [a-zA-Z]+)*$"))
                .map(BankName::new);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BankName that = (BankName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
