package com.leetcode.design_data_structures;

class Allocator2502_2 {
    private TreeMap<Integer, Integer> tm = new TreeMap<>();
    private Map<Integer, List<Integer>> d = new HashMap<>();

    public Allocator2502_2(int n) {
        tm.put(-1, -1);
        tm.put(n, n);
    }

    public int allocate(int size, int mID) {
        int s = -1;
        for (var entry : tm.entrySet()) {
            int v = entry.getKey();
            if (s != -1) {
                int e = v - 1;
                if (e - s + 1 >= size) {
                    tm.put(s, s + size - 1);
                    d.computeIfAbsent(mID, k -> new ArrayList<>()).add(s);
                    return s;
                }
            }
            s = entry.getValue() + 1;
        }
        return -1;
    }

    public int freeMemory(int mID) {
        int ans = 0;
        for (int s : d.getOrDefault(mID, List.of())) {
            int e = tm.remove(s);
            ans += e - s + 1;
        }
        d.remove(mID);
        return ans;
    }
}

/**
 * Your Allocator2502_2 object will be instantiated and called as such:
 * Allocator2502_2 obj = new Allocator2502_2(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */
