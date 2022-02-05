package se.omegapoint.kompetensdag.workshop.validation.tasks.model4;

import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.matchesPattern;
import static org.apache.commons.lang3.Validate.noNullElements;
import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;

public class Customer {
    public final String name;
    public final AccountInformation accountInformation;
    public final List<Pet> pets;

    public Customer(final String name, final AccountInformation accountInformation, final List<Pet> pets) {
        notBlank(name, "name can't be blank");
        isTrue(name.length() <= 100, "name can't be longer than 100 characters");
        matchesPattern(name, "^[a-zA-Z]+( [a-zA-Z]+)*$", "name contains illegal characters");
        
        notNull(accountInformation);
        
        noNullElements(pets);
        
        this.name = name;
        this.accountInformation = accountInformation;
        this.pets = pets;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(accountInformation, customer.accountInformation) && Objects.equals(pets, customer.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, accountInformation, pets);
    }
}
