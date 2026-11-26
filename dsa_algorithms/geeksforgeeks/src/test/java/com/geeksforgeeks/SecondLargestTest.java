package com.geeksforgeeks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondLargestTest {
    @Test
    void testGetSecondLargest() {
        SecondLargest solver = new SecondLargest();
        assertEquals(34, solver.getSecondLargest(new int[]{12, 35, 1, 10, 34, 1}));
    }
}
