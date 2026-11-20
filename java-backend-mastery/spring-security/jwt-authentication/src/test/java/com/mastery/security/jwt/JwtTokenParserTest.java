package com.mastery.security.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JwtTokenParserTest {

    @Test
    void extractsBearerToken() {
        var parser = new JwtTokenParser();
        assertEquals("abc.def.ghi", parser.extractBearerToken("Bearer abc.def.ghi").orElseThrow());
        assertTrue(parser.extractBearerToken("Basic xyz").isEmpty());
    }

    @Test
    void decodesPayload() {
        // header = {} , payload = {"sub":"1"}
        String jwt = "e30.eyJzdWIiOiIxIn0.signature";
        assertEquals("{\"sub\":\"1\"}", new JwtTokenParser().decodePayloadSegment(jwt));
    }
}
