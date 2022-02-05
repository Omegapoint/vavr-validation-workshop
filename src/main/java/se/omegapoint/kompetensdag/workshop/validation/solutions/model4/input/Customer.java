package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input;

import java.util.List;
import java.util.Objects;

public class Customer {
    public final String name;
    public final AccountInformation accountInformation;
    public final List<Pet> pets;

    public Customer(final String name, final AccountInformation accountInformation, final List<Pet> pets) {
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
