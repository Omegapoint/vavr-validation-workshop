package se.omegapoint.kompetensdag.workshop.validation.solutions.model4;

import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;
import se.omegapoint.kompetensdag.workshop.validation.solutions.model4.petdaycarecenter.OrganizationalNumber;

import static io.vavr.control.Validation.invalid;
import static io.vavr.control.Validation.valid;
import static java.lang.String.format;

public class ValidationUtils {
    public static Validation<String, String> notBlank(final String value, final String name) {
        return StringUtils.isBlank(value)
                ? invalid(format("%s can't be blank", name))
                : valid(value);
    }

    public static Validation<String, String> exactLength(final String value, final String name, final int length) {
        return value.length() == length
                ? valid(value)
                : invalid(format("%s must contain exactly %d characters", name, length));
    }

    public static Validation<String, String> maxLength(final String value, final String name, final int length) {
        return value.length() <= length
                ? valid(value)
                : invalid(format("%s can't contain more than %d characters", name, length));
    }

    public static Validation<String, String> minLength(final String value, final String name, final int length) {
        return value.length() >= length
                ? valid(value)
                : invalid(format("%s can't contain less than %d characters", name, length));
    }

    public static Validation<String, String> matchesPattern(final String value, final String name, final String pattern) {
        return value.matches(pattern)
                ? valid(value)
                : invalid(format("%s doesn't match the pattern %s", name, pattern));
    }
}
