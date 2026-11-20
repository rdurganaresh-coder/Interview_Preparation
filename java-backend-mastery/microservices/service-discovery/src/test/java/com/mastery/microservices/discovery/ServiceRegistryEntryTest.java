package com.mastery.microservices.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ServiceRegistryEntryTest {

    @Test
    void buildsBaseUri() {
        var entry = new ServiceRegistryEntry("payment-service", "10.0.1.12", 8082, true);
        assertEquals("http://10.0.1.12:8082", entry.baseUri());
    }
}
