package com.leetcode.arrays_hashing_greedy;

class Solution2376 {
    private char[] s;
    private Integer[][] f;

    public int countSpecialNumbers(int n) {
        s = String.valueOf(n).toCharArray();
        f = new Integer[s.length][1 << 10];
        return dfs(0, 0, true, true);
    }

    private int dfs(int i, int mask, boolean lead, boolean limit) {
        if (i >= s.length) {
            return lead ? 0 : 1;
        }
        if (!limit && !lead && f[i][mask] != null) {
            return f[i][mask];
        }
        int up = limit ? s[i] - '0' : 9;
        int ans = 0;
        for (int j = 0; j <= up; ++j) {
            if ((mask >> j & 1) == 1) {
                continue;
            }
            if (lead && j == 0) {
                ans += dfs(i + 1, mask, true, limit && j == up);
            } else {
                ans += dfs(i + 1, mask | (1 << j), false, limit && j == up);
            }
        }
        if (!limit && !lead) {
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
        Solution2376 _tcSol = new Solution2376();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 20");
        try {
            int n = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSpecialNumbers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5");
        try {
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSpecialNumbers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 135");
        try {
            int n = 135;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSpecialNumbers(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "110");
        System.out.println();
    }
}
