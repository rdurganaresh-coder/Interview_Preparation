package com.leetcode.bit_manipulation_math;

class Solution0788_2 {
    private char[] s;
    private Integer[][] f;

    public int rotatedDigits(int n) {
        s = String.valueOf(n).toCharArray();
        f = new Integer[s.length][2];
        return dfs(0, 0, true);
    }

    private int dfs(int i, int ok, boolean limit) {
        if (i >= s.length) {
            return ok;
        }
        if (!limit && f[i][ok] != null) {
            return f[i][ok];
        }
        int up = limit ? s[i] - '0' : 9;
        int ans = 0;
        for (int j = 0; j <= up; ++j) {
            if (j == 0 || j == 1 || j == 8) {
                ans += dfs(i + 1, ok, limit && j == up);
            } else if (j == 2 || j == 5 || j == 6 || j == 9) {
                ans += dfs(i + 1, 1, limit && j == up);
            }
        }
        if (!limit) {
            f[i][ok] = ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0788_2 _tcSol = new Solution0788_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 10");
        try {
            int n = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.rotatedDigits(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.rotatedDigits(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.rotatedDigits(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
