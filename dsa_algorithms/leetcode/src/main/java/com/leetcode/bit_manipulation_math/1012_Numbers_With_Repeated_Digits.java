package com.leetcode.bit_manipulation_math;

class Solution1012 {
    private char[] s;
    private Integer[][] f;

    public int numDupDigitsAtMostN(int n) {
        s = String.valueOf(n).toCharArray();
        f = new Integer[s.length][1 << 10];
        return n - dfs(0, 0, true, true);
    }

    private int dfs(int i, int mask, boolean lead, boolean limit) {
        if (i >= s.length) {
            return lead ? 0 : 1;
        }
        if (!lead && !limit && f[i][mask] != null) {
            return f[i][mask];
        }
        int up = limit ? s[i] - '0' : 9;
        int ans = 0;
        for (int j = 0; j <= up; ++j) {
            if (lead && j == 0) {
                ans += dfs(i + 1, mask, true, false);
            } else if ((mask >> j & 1) == 0) {
                ans += dfs(i + 1, mask | 1 << j, false, limit && j == up);
            }
        }
        if (!lead && !limit) {
            f[i][mask] = ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1012 _tcSol = new Solution1012();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 20");
        try {
            int n = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.numDupDigitsAtMostN(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 100");
        try {
            int n = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.numDupDigitsAtMostN(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 1000");
        try {
            int n = 1000;
            System.out.println("  Output  : " + _tcShow(_tcSol.numDupDigitsAtMostN(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "262");
        System.out.println();
    }
}