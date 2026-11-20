package com.mastery.microservices.resilience;

import java.util.function.Supplier;

public class SimpleCircuitBreaker {

    private final int failureThreshold;
    private int failures = 0;
    private boolean open = false;

    public SimpleCircuitBreaker(int failureThreshold) {
        this.failureThreshold = failureThreshold;
    }

    public <T> T execute(Supplier<T> action, Supplier<T> fallback) {
        if (open) {
            return fallback.get();
        }
        try {
            T result = action.get();
            failures = 0;
            return result;
        } catch (RuntimeException ex) {
            if (++failures >= failureThreshold) {
                open = true;
            }
            return fallback.get();
        }
    }

    public boolean isOpen() {
        return open;
    }
}
