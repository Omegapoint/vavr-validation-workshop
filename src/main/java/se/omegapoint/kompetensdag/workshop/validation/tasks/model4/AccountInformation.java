package se.omegapoint.kompetensdag.workshop.validation.tasks.model4;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.matchesPattern;
import static org.apache.commons.lang3.Validate.notBlank;

public class AccountInformation {
    public final String bankName;
    public final String accountNumber;
    public final String clearingNumber;
    
    public AccountInformation(final String bankName, final String accountNumber, final String clearingNumber) {
        notBlank(bankName, "bankName can't be blank");
        isTrue(bankName.length() <= 150, "bankName can't be longer than 150 characters");
        matchesPattern(bankName, "^[a-zA-Z]+( [a-zA-Z]+)*$", "bankName contains illegal characters");

        notBlank(accountNumber, "accountNumber can't be blank");
        isTrue(accountNumber.length() <= 15, "accountNumber can't be longer than 15 characters");
        matchesPattern(accountNumber, "^\\d{6,15}$", "accountNumber contains illegal characters");

        notBlank(clearingNumber, "clearingNumber can't be blank");
        isTrue(clearingNumber.length() == 4, "clearingNumber has to be 4 characters");
        matchesPattern(clearingNumber, "^\\d{4}$", "clearingNumber contains illegal characters");
        
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
