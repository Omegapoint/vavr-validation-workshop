package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.accountinformation;

import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.matchesPattern;
import static org.apache.commons.lang3.Validate.notBlank;

public class AccountInformation {
    public final BankName bankName;
    public final AccountNumber accountNumber;
    public final ClearingNumber clearingNumber;

    private AccountInformation(final BankName bankName, final AccountNumber accountNumber, final ClearingNumber clearingNumber) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.clearingNumber = clearingNumber;
    }

    public static Validation<String, AccountInformation> validate(final se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.AccountInformation accountInformation) {
        return Validation.combine(
                        BankName.validate(accountInformation.bankName),
                        AccountNumber.validate(accountInformation.accountNumber),
                        ClearingNumber.validate(accountInformation.clearingNumber)
                )
                .ap(AccountInformation::new)
                .mapError(errorMessages -> String.format("AccountInformation: [ %s ]", StringUtils.join(errorMessages, ", ")));
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
