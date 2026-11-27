package com.leetcode.arrays_hashing_greedy;

class Solution2361_2 {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long f = 0;
        long g = 1 << 30;
        long[] cost = new long[n];
        for (int i = 0; i < n; ++i) {
            int a = regular[i];
            int b = express[i];
            long ff = Math.min(f + a, g + a);
            long gg = Math.min(f + expressCost + b, g + b);
            f = ff;
            g = gg;
            cost[i] = Math.min(f, g);
        }
        return cost;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2361_2 _tcSol = new Solution2361_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "regular = [1,6,9,5], express = [5,2,3,10], expressCost = 8");
        try {
            int[] regular = new int[]{1, 6, 9, 5};
            int[] express = new int[]{5, 2, 3, 10};
            int expressCost = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCosts(regular, express, expressCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,7,14,19]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "regular = [11,5,13], express = [7,10,6], expressCost = 3");
        try {
            int[] regular = new int[]{11, 5, 13};
            int[] express = new int[]{7, 10, 6};
            int expressCost = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCosts(regular, express, expressCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,15,24]");
        System.out.println();
    }
}