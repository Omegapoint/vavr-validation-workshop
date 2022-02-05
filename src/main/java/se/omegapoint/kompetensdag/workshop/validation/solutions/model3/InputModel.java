package se.omegapoint.kompetensdag.workshop.validation.solutions.model3;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Objects;

public class InputModel {
    public final List<Pair<String, Integer>> people;

    public InputModel(final List<Pair<String, Integer>> people) {
        this.people = people;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final InputModel that = (InputModel) o;
        return Objects.equals(people, that.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(people);
    }
}
