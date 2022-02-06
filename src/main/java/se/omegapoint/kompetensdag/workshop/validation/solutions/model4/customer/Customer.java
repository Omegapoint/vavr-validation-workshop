package se.omegapoint.kompetensdag.workshop.validation.solutions.model4.customer;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.accountinformation.AccountInformation;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.pet.Pet;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Customer {
    public final Name name;
    public final AccountInformation accountInformation;
    public final List<Pet> pets;

    private Customer(final Name name, final AccountInformation accountInformation, final List<Pet> pets) {
        this.name = name;
        this.accountInformation = accountInformation;
        this.pets = pets;
    }

    public static Validation<String, List<Customer>> validateMultiple(final List<se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.Customer> customers) {
        return Validation.traverse(
                        IntStream.range(0, customers.size()).boxed().collect(Collectors.toList()),
                        index -> validate(customers.get(index), index + 1)
                                .mapError(io.vavr.collection.List::of)
                )
                .map(Seq::asJava)
                .mapError(errorMessages -> StringUtils.join(errorMessages, ",\n"));
    }

    private static Validation<String, Customer> validate(final se.omegapoint.kompetensdag.workshop.validation.solutions.model4.input.Customer customer, final Integer index) {
        return Validation.combine(
                        Name.validate(customer.name),
                        AccountInformation.validate(customer.accountInformation),
                        Pet.validateMultiple(customer.pets)
                )
                .ap(Customer::new)
                .mapError(errorMessages -> String.format("Customer %d: [\n%s\n]", index, StringUtils.join(errorMessages, ",\n")));
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
