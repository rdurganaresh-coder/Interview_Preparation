package com.dsa.stackqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ValidParenthesesTest {
    @Test
    void testReady() {
        assertEquals("stacks-queues ready", new ValidParentheses().status());
    }
}
