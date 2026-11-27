package com.leetcode.arrays_hashing_greedy;

class Solution0710 {
    private Map<Integer, Integer> d = new HashMap<>();
    private Random rand = new Random();
    private int k;

    public Solution0710(int n, int[] blacklist) {
        k = n - blacklist.length;
        int i = k;
        Set<Integer> black = new HashSet<>();
        for (int b : blacklist) {
            black.add(b);
        }
        for (int b : blacklist) {
            if (b < k) {
                while (black.contains(i)) {
                    ++i;
                }
                d.put(b, i++);
            }
        }
    }

    public int pick() {
        int x = rand.nextInt(k);
        return d.getOrDefault(x, x);
    }
}

/**
 * Your Solution0710 object will be instantiated and called as such:
 * Solution0710 obj = new Solution0710(n, blacklist);
 * int param_1 = obj.pick();
 */