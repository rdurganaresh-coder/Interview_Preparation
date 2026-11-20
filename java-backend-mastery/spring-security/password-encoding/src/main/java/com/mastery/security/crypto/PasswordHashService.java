package com.mastery.security.crypto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordHashService {

    private final PasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public boolean matches(String rawPassword, String encodedHash) {
        return encoder.matches(rawPassword, encodedHash);
    }
}
