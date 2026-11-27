package com.leetcode.arrays_hashing_greedy;

class Solution0650 {
    private int[] f;

    public int minSteps(int n) {
        f = new int[n + 1];
        Arrays.fill(f, -1);
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 1) {
            return 0;
        }
        if (f[n] != -1) {
            return f[n];
        }
        int ans = n;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                ans = Math.min(ans, dfs(n / i) + i);
            }
        }
        f[n] = ans;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0650 _tcSol = new Solution0650();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSteps(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSteps(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}