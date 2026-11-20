package com.learning.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Anna", "David");
        Map<Character, List<String>> grouped = names.stream()
                .filter(n -> n.length() >= 4)
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(n -> n.charAt(0)));
        System.out.println("Grouped Names: " + grouped);
    }
}
