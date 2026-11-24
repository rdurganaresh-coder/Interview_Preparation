package com.dsa.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CoinChangeSolverTest {
    @Test
    void testReady() {
        assertEquals("dynamic-programming ready", new CoinChangeSolver().status());
    }
}
