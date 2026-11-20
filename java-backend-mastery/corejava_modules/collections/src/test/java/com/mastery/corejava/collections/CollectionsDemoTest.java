package com.mastery.corejava.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class CollectionsDemoTest {

    @Test
    void wordFrequencyIsCaseInsensitive() {
        var demo = new CollectionsDemo();
        long count = demo.wordFrequency(List.of("Java", "java", "Spring")).get("java");
        assertEquals(2L, count);
    }

    @Test
    void topKReturnsLargestDescending() {
        var demo = new CollectionsDemo();
        assertEquals(List.of(9, 7), demo.topKElements(List.of(3, 9, 1, 7, 4), 2));
    }
}
