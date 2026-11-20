package com.mastery.microservices.gateway;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RouteMatcherTest {

    @Test
    void resolvesKnownPrefix() {
        assertEquals("lb://order-service", new RouteMatcher().resolveTarget("/api/orders/42").orElseThrow());
    }

    @Test
    void unknownPathHasNoRoute() {
        assertTrue(new RouteMatcher().resolveTarget("/unknown").isEmpty());
    }
}
