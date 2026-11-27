package com.leetcode.sliding_window_two_pointers;

class NumberContainers2349 {
    private Map<Integer, Integer> d = new HashMap<>();
    private Map<Integer, TreeSet<Integer>> g = new HashMap<>();

    public NumberContainers2349() {
    }

    public void change(int index, int number) {
        if (d.containsKey(index)) {
            int oldNumber = d.get(index);
            g.get(oldNumber).remove(index);
        }
        d.put(index, number);
        g.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        var ids = g.get(number);
        return ids == null || ids.isEmpty() ? -1 : ids.first();
    }
}

/**
 * Your NumberContainers2349 object will be instantiated and called as such:
 * NumberContainers2349 obj = new NumberContainers2349();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */