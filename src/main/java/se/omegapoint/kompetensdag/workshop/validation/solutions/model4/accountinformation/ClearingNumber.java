package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.accountinformation;

import io.vavr.control.Validation;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.ValidationUtils;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;

public class ClearingNumber {
    public final String value;

    private ClearingNumber(final String value) {
        this.value = notBlank(value);
    }

    public static Validation<String, ClearingNumber> validate(final String clearingNumber) {
        return ValidationUtils.notBlank(clearingNumber, "clearingNumber")
                .flatMap(clearNum -> ValidationUtils.exactLength(clearNum, "clearingNumber", 4))
                .flatMap(clearNum -> ValidationUtils.matchesPattern(clearNum, "clearingNumber", "^\\d{4}$"))
                .map(ClearingNumber::new);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ClearingNumber that = (ClearingNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
