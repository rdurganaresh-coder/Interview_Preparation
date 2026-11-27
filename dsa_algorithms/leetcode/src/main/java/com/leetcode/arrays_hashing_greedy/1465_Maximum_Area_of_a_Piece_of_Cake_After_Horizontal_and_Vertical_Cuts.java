package com.leetcode.arrays_hashing_greedy;

class Solution1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final int mod = (int) 1e9 + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m = horizontalCuts.length;
        int n = verticalCuts.length;
        long x = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]);
        long y = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);
        for (int i = 1; i < m; ++i) {
            x = Math.max(x, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < n; ++i) {
            y = Math.max(y, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int) ((x * y) % mod);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1465 _tcSol = new Solution1465();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]");
        try {
            int h = 5;
            int w = 4;
            int[] horizontalCuts = new int[]{1, 2, 4};
            int[] verticalCuts = new int[]{1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArea(h, w, horizontalCuts, verticalCuts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]");
        try {
            int h = 5;
            int w = 4;
            int[] horizontalCuts = new int[]{3, 1};
            int[] verticalCuts = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArea(h, w, horizontalCuts, verticalCuts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]");
        try {
            int h = 5;
            int w = 4;
            int[] horizontalCuts = new int[]{3};
            int[] verticalCuts = new int[]{3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArea(h, w, horizontalCuts, verticalCuts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}