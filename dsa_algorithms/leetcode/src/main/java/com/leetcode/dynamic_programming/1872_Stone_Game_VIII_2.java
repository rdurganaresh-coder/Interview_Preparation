package com.leetcode.dynamic_programming;

class Solution1872_2 {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        for (int i = 1; i < n; ++i) {
            stones[i] += stones[i - 1];
        }
        int f = stones[n - 1];
        for (int i = n - 2; i > 0; --i) {
            f = Math.max(f, stones[i] - f);
        }
        return f;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1872_2 _tcSol = new Solution1872_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [-1,2,-3,4,-5]");
        try {
            int[] stones = new int[]{-1, 2, -3, 4, -5};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameVIII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [7,-6,5,10,5,-2,-6]");
        try {
            int[] stones = new int[]{7, -6, 5, 10, 5, -2, -6};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameVIII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "stones = [-10,-12]");
        try {
            int[] stones = new int[]{-10, -12};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameVIII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-22");
        System.out.println();
    }
}