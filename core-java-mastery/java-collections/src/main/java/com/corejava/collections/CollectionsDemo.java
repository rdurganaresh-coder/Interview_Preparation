package com.corejava.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionsDemo {

    public static class LruCache<K, V> extends LinkedHashMap<K, V> {
        private final int maxEntries;

        public LruCache(int maxEntries) {
            super(maxEntries, 0.75f, true);
            this.maxEntries = maxEntries;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maxEntries;
        }
    }

    public static void main(String[] args) {
        LruCache<Integer, String> cache = new LruCache<>(2);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.get(1);
        cache.put(3, "Three");
        System.out.println("Cache keys: " + cache.keySet());
    }
}
