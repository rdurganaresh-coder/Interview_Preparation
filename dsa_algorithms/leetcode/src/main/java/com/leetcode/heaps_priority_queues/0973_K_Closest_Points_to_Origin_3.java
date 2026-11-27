package com.leetcode.heaps_priority_queues;

class Solution0973_3 {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[] dist = new int[n];
        int r = 0;
        for (int i = 0; i < n; ++i) {
            int x = points[i][0], y = points[i][1];
            dist[i] = x * x + y * y;
            r = Math.max(r, dist[i]);
        }
        int l = 0;
        while (l < r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int d : dist) {
                if (d <= mid) {
                    ++cnt;
                }
            }
            if (cnt >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int[][] ans = new int[k][0];
        for (int i = 0, j = 0; i < n; ++i) {
            if (dist[i] <= l) {
                ans[j++] = points[i];
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0973_3 _tcSol = new Solution0973_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,3],[-2,2]], k = 1");
        try {
            int[][] points = new int[][]{new int[]{1, 3}, new int[]{-2, 2}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kClosest(points, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[-2,2]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[3,3],[5,-1],[-2,4]], k = 2");
        try {
            int[][] points = new int[][]{new int[]{3, 3}, new int[]{5, -1}, new int[]{-2, 4}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kClosest(points, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,3],[-2,4]]");
        System.out.println();
    }
}
