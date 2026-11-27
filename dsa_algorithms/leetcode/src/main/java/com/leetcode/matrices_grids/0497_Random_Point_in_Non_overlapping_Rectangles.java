package com.leetcode.matrices_grids;

class Solution0497 {
    private int[] s;
    private int[][] rects;
    private Random random = new Random();

    public Solution0497(int[][] rects) {
        int n = rects.length;
        s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
        }
        this.rects = rects;
    }

    public int[] pick() {
        int n = rects.length;
        int v = 1 + random.nextInt(s[n]);
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (s[mid] >= v) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int[] rect = rects[left - 1];
        return new int[] {rect[0] + random.nextInt(rect[2] - rect[0] + 1),
            rect[1] + random.nextInt(rect[3] - rect[1] + 1)};
    }
}

/**
 * Your Solution0497 object will be instantiated and called as such:
 * Solution0497 obj = new Solution0497(rects);
 * int[] param_1 = obj.pick();
 */