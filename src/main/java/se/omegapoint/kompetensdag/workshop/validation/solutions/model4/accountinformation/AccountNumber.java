package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.accountinformation;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;

public class AccountNumber {
    public final String value;

    private AccountNumber(final String value) {
        this.value = notBlank(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AccountNumber that = (AccountNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
