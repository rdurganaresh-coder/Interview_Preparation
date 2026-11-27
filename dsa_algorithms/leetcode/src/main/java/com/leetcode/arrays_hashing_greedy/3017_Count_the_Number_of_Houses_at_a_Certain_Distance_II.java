package com.leetcode.arrays_hashing_greedy;

class Solution3017 {
    public long[] countOfPairs(int n, int x, int y) {
        --x;
        --y;
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        long[] diff = new long[n];
        for (int i = 0; i < n; ++i) {
            diff[0] += 1 + 1;
            ++diff[Math.min(Math.abs(i - x), Math.abs(i - y) + 1)];
            ++diff[Math.min(Math.abs(i - y), Math.abs(i - x) + 1)];
            --diff[Math.min(Math.abs(i - 0), Math.abs(i - y) + 1 + Math.abs(x - 0))];
            --diff[Math.min(Math.abs(i - (n - 1)), Math.abs(i - x) + 1 + Math.abs(y - (n - 1)))];
            --diff[Math.max(x - i, 0) + Math.max(i - y, 0) + ((y - x) + 0) / 2];
            --diff[Math.max(x - i, 0) + Math.max(i - y, 0) + ((y - x) + 1) / 2];
        }
        for (int i = 0; i + 1 < n; ++i) {
            diff[i + 1] += diff[i];
        }
        return diff;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3017 _tcSol = new Solution3017();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, x = 1, y = 3");
        try {
            int n = 3;
            int x = 1;
            int y = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfPairs(n, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,0,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, x = 2, y = 4");
        try {
            int n = 5;
            int x = 2;
            int y = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfPairs(n, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,8,2,0,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, x = 1, y = 1");
        try {
            int n = 4;
            int x = 1;
            int y = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfPairs(n, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,4,2,0]");
        System.out.println();
    }
}
