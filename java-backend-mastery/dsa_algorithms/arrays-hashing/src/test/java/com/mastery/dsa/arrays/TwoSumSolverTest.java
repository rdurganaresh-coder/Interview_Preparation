package com.mastery.dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TwoSumSolverTest {

    @Test
    void findsPair() {
        assertArrayEquals(new int[] {0, 1}, new TwoSumSolver().twoSum(new int[] {2, 7, 11}, 9));
    }

    @Test
    void throwsWhenNoPair() {
        assertThrows(IllegalArgumentException.class,
                () -> new TwoSumSolver().twoSum(new int[] {1, 2}, 100));
    }
}
