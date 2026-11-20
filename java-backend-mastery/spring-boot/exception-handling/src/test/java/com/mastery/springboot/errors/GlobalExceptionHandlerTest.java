package com.mastery.springboot.errors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GlobalExceptionHandlerTest {

    @Test
    void mapsToProblemDetail() {
        var pd = new GlobalExceptionHandler().handleBadRequest(new IllegalArgumentException("Bad ID"));
        assertEquals(400, pd.getStatus());
        assertEquals("Invalid Request", pd.getTitle());
    }
}
