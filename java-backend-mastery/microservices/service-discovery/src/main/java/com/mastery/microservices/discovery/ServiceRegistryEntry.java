package com.mastery.microservices.discovery;

public record ServiceRegistryEntry(String serviceId, String host, int port, boolean healthy) {

    public String baseUri() {
        return "http://" + host + ":" + port;
    }
}
