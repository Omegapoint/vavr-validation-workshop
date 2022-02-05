package se.omegapoint.kompetensdag.workshop.validation.tasks.model4;

import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.matchesPattern;
import static org.apache.commons.lang3.Validate.noNullElements;
import static org.apache.commons.lang3.Validate.notBlank;

public class PetDaycareCenter {
    public final String organizationalNumber;
    public final String name;
    public final List<Customer> customers;

    public PetDaycareCenter(final String organizationalNumber, final String name, final List<Customer> customers) {
        notBlank(organizationalNumber, "organizationalNumber can't be blank");
        isTrue(organizationalNumber.length() == 10, "organizationalNumber can't be longer than 100 characters");
        matchesPattern(organizationalNumber, "^[\\da-zA-Z]{10}$", "organizationalNumber contains illegal characters");
        
        notBlank(name, "name can't be blank");
        isTrue(name.length() <= 100, "name can't be longer than 100 characters");
        matchesPattern(name, "^[a-zA-Z]+( [a-zA-Z]+)*$", "name contains illegal characters");
        
        noNullElements(customers);
        
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
