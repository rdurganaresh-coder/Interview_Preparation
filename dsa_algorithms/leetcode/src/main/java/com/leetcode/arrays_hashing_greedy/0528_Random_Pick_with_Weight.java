package com.leetcode.arrays_hashing_greedy;

class Solution0528 {
    private int[] s;
    private Random random = new Random();

    public Solution0528(int[] w) {
        int n = w.length;
        s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + w[i];
        }
    }

    public int pickIndex() {
        int x = 1 + random.nextInt(s[s.length - 1]);
        int left = 1, right = s.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (s[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}

/**
 * Your Solution0528 object will be instantiated and called as such:
 * Solution0528 obj = new Solution0528(w);
 * int param_1 = obj.pickIndex();
 */