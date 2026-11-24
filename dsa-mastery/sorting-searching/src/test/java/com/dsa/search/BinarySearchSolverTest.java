package com.dsa.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BinarySearchSolverTest {
    @Test
    void testReady() {
        assertEquals("sorting-searching ready", new BinarySearchSolver().status());
    }
}
