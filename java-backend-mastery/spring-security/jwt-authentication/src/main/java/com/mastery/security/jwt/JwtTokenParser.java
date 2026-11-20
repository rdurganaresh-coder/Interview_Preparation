package com.mastery.security.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

public class JwtTokenParser {

    public Optional<String> extractBearerToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return Optional.empty();
        }
        String token = authorizationHeader.substring(7).trim();
        return token.isEmpty() ? Optional.empty() : Optional.of(token);
    }

    /** Decodes (does NOT verify) the payload segment of a JWT. */
    public String decodePayloadSegment(String jwt) {
        String[] parts = jwt.split("[.]");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Malformed JWT");
        }
        return new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);
    }
}
