package com.mastery.security.crypto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PasswordHashServiceTest {

    @Test
    void bcryptRoundTrip() {
        var service = new PasswordHashService();
        String hash = service.encode("S3cur3P@ss!");
        assertTrue(service.matches("S3cur3P@ss!", hash));
        assertFalse(service.matches("wrong", hash));
    }
}
