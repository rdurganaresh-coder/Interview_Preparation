package com.mastery.dsa.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CoinChangeSolverTest {

    @Test
    void minimumCoins() {
        assertEquals(3, new CoinChangeSolver().minCoins(new int[] {1, 2, 5}, 11));
    }

    @Test
    void impossibleAmount() {
        assertEquals(-1, new CoinChangeSolver().minCoins(new int[] {2}, 3));
    }
}
