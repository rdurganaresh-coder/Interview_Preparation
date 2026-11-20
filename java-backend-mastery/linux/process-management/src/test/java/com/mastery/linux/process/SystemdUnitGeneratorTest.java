package com.mastery.linux.process;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SystemdUnitGeneratorTest {

    @Test
    void containsExecStart() {
        String unit = new SystemdUnitGenerator().generateServiceUnit("OrderService", "/opt/app.jar");
        assertTrue(unit.contains("ExecStart=/usr/bin/java -jar /opt/app.jar"));
        assertTrue(unit.contains("Description=OrderService"));
    }
}
