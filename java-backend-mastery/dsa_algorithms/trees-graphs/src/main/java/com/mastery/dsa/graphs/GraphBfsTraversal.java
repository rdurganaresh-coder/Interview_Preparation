package com.mastery.dsa.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphBfsTraversal {

    public List<Integer> bfs(Map<Integer, List<Integer>> adj, int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        visited.add(start);
        queue.offer(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : adj.getOrDefault(node, List.of())) {
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return order;
    }
}
