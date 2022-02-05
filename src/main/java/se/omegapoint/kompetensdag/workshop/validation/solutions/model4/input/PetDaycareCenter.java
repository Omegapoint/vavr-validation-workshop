package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input;

import java.util.List;
import java.util.Objects;

public class PetDaycareCenter {
    public final String organizationalNumber;
    public final String name;
    public final List<Customer> customers;

    public PetDaycareCenter(final String organizationalNumber, final String name, final List<Customer> customers) {
        this.organizationalNumber = organizationalNumber;
        this.name = name;
        this.customers = customers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PetDaycareCenter that = (PetDaycareCenter) o;
        return Objects.equals(organizationalNumber, that.organizationalNumber) && Objects.equals(name, that.name) && Objects.equals(customers, that.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationalNumber, name, customers);
    }
}
