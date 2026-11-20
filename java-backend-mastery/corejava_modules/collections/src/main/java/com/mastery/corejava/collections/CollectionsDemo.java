package com.mastery.corejava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CollectionsDemo {

    public Map<String, Long> wordFrequency(List<String> words) {
        Map<String, Long> freq = new LinkedHashMap<>();
        for (String w : words) {
            freq.merge(w.toLowerCase(), 1L, Long::sum);
        }
        return freq;
    }

    public List<Integer> topKElements(List<Integer> nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> result = new ArrayList<>(minHeap);
        result.sort(Collections.reverseOrder());
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
