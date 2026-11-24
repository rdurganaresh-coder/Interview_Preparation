package com.dsa.treegraph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TreeTraversalTest {
    @Test
    void testReady() {
        assertEquals("trees-graphs ready", new TreeTraversal().status());
    }
}
