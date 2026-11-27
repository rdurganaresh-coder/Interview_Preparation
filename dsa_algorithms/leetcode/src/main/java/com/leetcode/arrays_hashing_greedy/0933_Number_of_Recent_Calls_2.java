package com.leetcode.arrays_hashing_greedy;

class RecentCounter0933_2 {
    private int[] s = new int[10010];
    private int idx;

    public RecentCounter0933_2() {
    }

    public int ping(int t) {
        s[idx++] = t;
        return idx - search(t - 3000);
    }

    private int search(int x) {
        int left = 0, right = idx;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (s[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
 * Your RecentCounter0933_2 object will be instantiated and called as such:
 * RecentCounter0933_2 obj = new RecentCounter0933_2();
 * int param_1 = obj.ping(t);
 */
