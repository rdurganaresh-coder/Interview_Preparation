package com.learning.collections;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 88);
        scores.put("Charlie", 92);
        scores.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
