package com.mastery.linux.network;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PortValidatorTest {

    @Test
    void distinguishesPrivilegedPorts() {
        var validator = new PortValidator();
        assertTrue(validator.isUserSpacePort(8080));
        assertFalse(validator.isUserSpacePort(80));
        assertFalse(validator.isUserSpacePort(70000));
    }
}
