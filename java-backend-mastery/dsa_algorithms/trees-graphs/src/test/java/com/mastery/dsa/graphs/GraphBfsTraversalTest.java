package com.mastery.dsa.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GraphBfsTraversalTest {

    @Test
    void traversesLevelByLevel() {
        Map<Integer, List<Integer>> graph = Map.of(1, List.of(2, 3), 2, List.of(4));
        assertEquals(List.of(1, 2, 3, 4), new GraphBfsTraversal().bfs(graph, 1));
    }
}
