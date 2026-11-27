package com.leetcode.arrays_hashing_greedy;

import java.math.BigInteger;

class Solution2719 {
    private final int mod = (int) 1e9 + 7;
    private Integer[][] f;
    private String num;
    private int min;
    private int max;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        min = min_sum;
        max = max_sum;
        num = num2;
        f = new Integer[23][220];
        int a = dfs(0, 0, true);
        num = new BigInteger(num1).subtract(BigInteger.ONE).toString();
        f = new Integer[23][220];
        int b = dfs(0, 0, true);
        return (a - b + mod) % mod;
    }

    private int dfs(int pos, int s, boolean limit) {
        if (pos >= num.length()) {
            return s >= min && s <= max ? 1 : 0;
        }
        if (!limit && f[pos][s] != null) {
            return f[pos][s];
        }
        int ans = 0;
        int up = limit ? num.charAt(pos) - '0' : 9;
        for (int i = 0; i <= up; ++i) {
            ans = (ans + dfs(pos + 1, s + i, limit && i == up)) % mod;
        }
        if (!limit) {
            f[pos][s] = ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2719 _tcSol = new Solution2719();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num1 = \"1\", num2 = \"12\", min_sum = 1, max_sum = 8");
        try {
            String num1 = "1";
            String num2 = "12";
            int min_sum = 1;
            int max_sum = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.count(num1, num2, min_sum, max_sum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num1 = \"1\", num2 = \"5\", min_sum = 1, max_sum = 5");
        try {
            String num1 = "1";
            String num2 = "5";
            int min_sum = 1;
            int max_sum = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.count(num1, num2, min_sum, max_sum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}