package com.leetcode.bit_manipulation_math;

class Solution0357 {
    private Integer[][] f;

    public int countNumbersWithUniqueDigits(int n) {
        f = new Integer[n][1 << 10];
        return dfs(n - 1, 0, true);
    }

    private int dfs(int i, int mask, boolean lead) {
        if (i < 0) {
            return 1;
        }
        if (!lead && f[i][mask] != null) {
            return f[i][mask];
        }
        int ans = 0;
        for (int j = 0; j <= 9; ++j) {
            if ((mask >> j & 1) == 1) {
                continue;
            }
            if (lead && j == 0) {
                ans += dfs(i - 1, mask, true);
            } else {
                ans += dfs(i - 1, mask | 1 << j, false);
            }
        }
        if (!lead) {
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
        Solution0357 _tcSol = new Solution0357();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countNumbersWithUniqueDigits(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "91");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 0");
        try {
            int n = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.countNumbersWithUniqueDigits(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
