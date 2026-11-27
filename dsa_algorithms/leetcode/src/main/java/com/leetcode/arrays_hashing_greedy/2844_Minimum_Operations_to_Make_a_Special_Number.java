package com.leetcode.arrays_hashing_greedy;

class Solution2844 {
    private Integer[][] f;
    private String num;
    private int n;

    public int minimumOperations(String num) {
        n = num.length();
        this.num = num;
        f = new Integer[n][25];
        return dfs(0, 0);
    }

    private int dfs(int i, int k) {
        if (i == n) {
            return k == 0 ? 0 : n;
        }
        if (f[i][k] != null) {
            return f[i][k];
        }
        f[i][k] = dfs(i + 1, k) + 1;
        f[i][k] = Math.min(f[i][k], dfs(i + 1, (k * 10 + num.charAt(i) - '0') % 25));
        return f[i][k];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2844 _tcSol = new Solution2844();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"2245047\"");
        try {
            String num = "2245047";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"2908305\"");
        try {
            String num = "2908305";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = \"10\"");
        try {
            String num = "10";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}