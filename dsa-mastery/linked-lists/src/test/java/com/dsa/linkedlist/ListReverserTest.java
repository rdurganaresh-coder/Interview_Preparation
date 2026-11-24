package com.dsa.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ListReverserTest {
    @Test
    void testReady() {
        assertEquals("linked-lists ready", new ListReverser().status());
    }
}
