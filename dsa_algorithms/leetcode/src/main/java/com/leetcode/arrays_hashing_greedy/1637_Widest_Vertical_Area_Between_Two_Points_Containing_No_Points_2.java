package com.leetcode.arrays_hashing_greedy;

class Solution1637_2 {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = points[i][0];
        }
        final int inf = 1 << 30;
        int mi = inf, mx = -inf;
        for (int v : nums) {
            mi = Math.min(mi, v);
            mx = Math.max(mx, v);
        }
        int bucketSize = Math.max(1, (mx - mi) / (n - 1));
        int bucketCount = (mx - mi) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][2];
        for (var bucket : buckets) {
            bucket[0] = inf;
            bucket[1] = -inf;
        }
        for (int v : nums) {
            int i = (v - mi) / bucketSize;
            buckets[i][0] = Math.min(buckets[i][0], v);
            buckets[i][1] = Math.max(buckets[i][1], v);
        }
        int prev = inf;
        int ans = 0;
        for (var bucket : buckets) {
            if (bucket[0] > bucket[1]) {
                continue;
            }
            ans = Math.max(ans, bucket[0] - prev);
            prev = bucket[1];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1637_2 _tcSol = new Solution1637_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[8,7],[9,9],[7,4],[9,7]]");
        try {
            int[][] points = new int[][]{new int[]{8, 7}, new int[]{9, 9}, new int[]{7, 4}, new int[]{9, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxWidthOfVerticalArea(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]");
        try {
            int[][] points = new int[][]{new int[]{3, 1}, new int[]{9, 0}, new int[]{1, 0}, new int[]{1, 4}, new int[]{5, 3}, new int[]{8, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxWidthOfVerticalArea(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}