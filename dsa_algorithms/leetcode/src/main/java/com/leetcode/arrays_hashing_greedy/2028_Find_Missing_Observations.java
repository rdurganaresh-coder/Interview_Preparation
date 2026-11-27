package com.leetcode.arrays_hashing_greedy;

class Solution2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int s = (n + m) * mean;
        for (int v : rolls) {
            s -= v;
        }
        if (s > n * 6 || s < n) {
            return new int[0];
        }
        int[] ans = new int[n];
        Arrays.fill(ans, s / n);
        for (int i = 0; i < s % n; ++i) {
            ++ans[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2028 _tcSol = new Solution2028();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rolls = [3,2,4,3], mean = 4, n = 2");
        try {
            int[] rolls = new int[]{3, 2, 4, 3};
            int mean = 4;
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.missingRolls(rolls, mean, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rolls = [1,5,6], mean = 3, n = 4");
        try {
            int[] rolls = new int[]{1, 5, 6};
            int mean = 3;
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.missingRolls(rolls, mean, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,2,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rolls = [1,2,3,4], mean = 6, n = 4");
        try {
            int[] rolls = new int[]{1, 2, 3, 4};
            int mean = 6;
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.missingRolls(rolls, mean, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}