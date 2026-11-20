package com.mastery.corejava.oop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OopConceptsDemoTest {

    @Test
    void sealedShapesComputeArea() {
        OopConceptsDemo.Shape rect = new OopConceptsDemo.Rectangle(4, 5);
        assertEquals(20.0, rect.area());
    }

    @Test
    void patternMatchingSwitch() {
        assertEquals("Rectangle 4.0x5.0",
                OopConceptsDemo.describe(new OopConceptsDemo.Rectangle(4, 5)));
    }
}
