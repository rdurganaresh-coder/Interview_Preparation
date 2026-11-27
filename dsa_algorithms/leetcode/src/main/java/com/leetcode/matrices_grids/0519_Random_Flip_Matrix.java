package com.leetcode.matrices_grids;

class Solution0519 {
    private int m;
    private int n;
    private int total;
    private Random rand = new Random();
    private Map<Integer, Integer> mp = new HashMap<>();

    public Solution0519(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
    }

    public int[] flip() {
        int x = rand.nextInt(total--);
        int idx = mp.getOrDefault(x, x);
        mp.put(x, mp.getOrDefault(total, total));
        return new int[] {idx / n, idx % n};
    }

    public void reset() {
        total = m * n;
        mp.clear();
    }
}

/**
 * Your Solution0519 object will be instantiated and called as such:
 * Solution0519 obj = new Solution0519(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */