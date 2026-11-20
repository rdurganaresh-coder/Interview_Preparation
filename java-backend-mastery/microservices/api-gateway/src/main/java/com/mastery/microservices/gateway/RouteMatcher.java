package com.mastery.microservices.gateway;

import java.util.Map;
import java.util.Optional;

public class RouteMatcher {

    private final Map<String, String> prefixRoutes = Map.of(
            "/api/users", "lb://user-service",
            "/api/orders", "lb://order-service");

    public Optional<String> resolveTarget(String requestPath) {
        return prefixRoutes.entrySet().stream()
                .filter(e -> requestPath.startsWith(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();
    }
}
