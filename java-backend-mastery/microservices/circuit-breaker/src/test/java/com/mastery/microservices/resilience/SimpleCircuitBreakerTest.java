package com.mastery.microservices.resilience;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SimpleCircuitBreakerTest {

    @Test
    void tripsAfterThresholdFailures() {
        var cb = new SimpleCircuitBreaker(2);
        cb.execute(() -> { throw new RuntimeException("boom"); }, () -> "fallback");
        assertFalse(cb.isOpen());
        cb.execute(() -> { throw new RuntimeException("boom"); }, () -> "fallback");
        assertTrue(cb.isOpen());
        assertEquals("fallback", cb.execute(() -> "ok", () -> "fallback"));
    }
}
