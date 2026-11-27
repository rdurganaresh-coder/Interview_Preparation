package com.leetcode.arrays_hashing_greedy;

class Solution3015 {
    public int[] countOfPairs(int n, int x, int y) {
        int[] ans = new int[n];
        x--;
        y--;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int a = j - i;
                int b = Math.abs(i - x) + 1 + Math.abs(j - y);
                int c = Math.abs(i - y) + 1 + Math.abs(j - x);
                ans[Math.min(a, Math.min(b, c)) - 1] += 2;
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
        Solution3015 _tcSol = new Solution3015();
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