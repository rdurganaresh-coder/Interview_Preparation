package com.corejava.patterns;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DesignPatternsDemoTest {

    @Test
    void shouldApplyVipStrategy() {
        assertEquals(150.0, DesignPatternsDemo.calculatePrice("VIP_25", 200.0), 0.001);
    }
}
