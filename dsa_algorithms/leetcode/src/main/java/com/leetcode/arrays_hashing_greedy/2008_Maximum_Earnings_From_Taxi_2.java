package com.leetcode.arrays_hashing_greedy;

class Solution2008_2 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        int m = rides.length;
        long[] f = new long[m + 1];
        for (int i = 1; i <= m; ++i) {
            int[] r = rides[i - 1];
            int st = r[0], ed = r[1], tip = r[2];
            int j = search(rides, st + 1, i);
            f[i] = Math.max(f[i - 1], f[j] + ed - st + tip);
        }
        return f[m];
    }

    private int search(int[][] nums, int x, int r) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid][1] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2008_2 _tcSol = new Solution2008_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, rides = [[2,5,4],[1,5,1]]");
        try {
            int n = 5;
            int[][] rides = new int[][]{new int[]{2, 5, 4}, new int[]{1, 5, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTaxiEarnings(n, rides)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]");
        try {
            int n = 20;
            int[][] rides = new int[][]{new int[]{1, 6, 1}, new int[]{3, 10, 2}, new int[]{10, 12, 3}, new int[]{11, 12, 2}, new int[]{12, 15, 2}, new int[]{13, 18, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTaxiEarnings(n, rides)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}