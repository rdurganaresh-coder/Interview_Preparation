package com.leetcode.sliding_window_two_pointers;

class Solution0600 {
    private int n;
    private Integer[][] f;

    public int findIntegers(int n) {
        this.n = n;
        int m = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        f = new Integer[m][2];
        return dfs(m - 1, 0, true);
    }

    private int dfs(int i, int pre, boolean limit) {
        if (i < 0) {
            return 1;
        }
        if (!limit && f[i][pre] != null) {
            return f[i][pre];
        }
        int up = limit ? (n >> i & 1) : 1;
        int ans = 0;
        for (int j = 0; j <= up; ++j) {
            if (j == 1 && pre == 1) {
                continue;
            }
            ans += dfs(i - 1, j, limit && j == up);
        }
        if (!limit) {
            f[i][pre] = ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0600 _tcSol = new Solution0600();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5");
        try {
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.findIntegers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findIntegers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findIntegers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
