package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.petdaycarecenter;


import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.customer.Customer;

import java.util.List;
import java.util.Objects;

public class PetDaycareCenter {
    public final OrganizationalNumber organizationalNumber;
    public final Name name;
    public final List<Customer> customers;

    private PetDaycareCenter(final OrganizationalNumber organizationalNumber, final Name name, final List<Customer> customers) {
        this.organizationalNumber = organizationalNumber;
        this.name = name;
        this.customers = customers;
    }

    public static Validation<String, PetDaycareCenter> validate(final se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.PetDaycareCenter input) {
        return Validation.combine(
                OrganizationalNumber.validate(input.organizationalNumber),
                Name.validate(input.name),
                Customer.validateMultiple(input.customers)
        )
                .ap(PetDaycareCenter::new)
                .mapError(errorMessages -> StringUtils.join(errorMessages, ", "));
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
