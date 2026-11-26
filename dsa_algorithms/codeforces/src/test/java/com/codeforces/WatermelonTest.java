package com.codeforces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WatermelonTest {
    @Test
    void testWatermelon() {
        assertEquals("YES", Watermelon.solve(8));
        assertEquals("NO", Watermelon.solve(2));
    }
}
