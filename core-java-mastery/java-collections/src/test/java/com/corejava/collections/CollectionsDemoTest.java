package com.corejava.collections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CollectionsDemoTest {

    @Test
    void shouldEvictLeastRecentlyUsedKey() {
        var cache = new CollectionsDemo.LruCache<Integer, String>(2);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.get(1);
        cache.put(3, "C");

        assertFalse(cache.containsKey(2));
        assertTrue(cache.containsKey(1));
        assertTrue(cache.containsKey(3));
    }
}
