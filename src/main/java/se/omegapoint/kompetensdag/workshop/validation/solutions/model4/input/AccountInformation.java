package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input;

import java.util.Objects;

public class AccountInformation {
    public final String bankName;
    public final String accountNumber;
    public final String clearingNumber;

    public AccountInformation(final String bankName, final String accountNumber, final String clearingNumber) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.clearingNumber = clearingNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AccountInformation that = (AccountInformation) o;
        return Objects.equals(bankName, that.bankName) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(clearingNumber, that.clearingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, accountNumber, clearingNumber);
    }
}
