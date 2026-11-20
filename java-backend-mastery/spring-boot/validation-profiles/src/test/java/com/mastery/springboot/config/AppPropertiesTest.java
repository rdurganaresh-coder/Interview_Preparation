package com.mastery.springboot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.validation.Validation;
import org.junit.jupiter.api.Test;

class AppPropertiesTest {

    @Test
    void validRecordHasNoViolations() {
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var violations = factory.getValidator().validate(new AppProperties("prod", 3));
            assertEquals(0, violations.size());
        }
    }

    @Test
    void invalidRecordHasViolations() {
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var violations = factory.getValidator().validate(new AppProperties("", 0));
            assertEquals(2, violations.size());
        }
    }
}
