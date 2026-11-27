package com.leetcode.dynamic_programming;

class Solution2522 {
    private Integer[] f;
    private int n;
    private String s;
    private int k;
    private int inf = 1 << 30;

    public int minimumPartition(String s, int k) {
        n = s.length();
        f = new Integer[n];
        this.s = s;
        this.k = k;
        int ans = dfs(0);
        return ans < inf ? ans : -1;
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        int res = inf;
        long v = 0;
        for (int j = i; j < n; ++j) {
            v = v * 10 + (s.charAt(j) - '0');
            if (v > k) {
                break;
            }
            res = Math.min(res, dfs(j + 1));
        }
        return f[i] = res + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2522 _tcSol = new Solution2522();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"165462\", k = 60");
        try {
            String s = "165462";
            int k = 60;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPartition(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"238182\", k = 5");
        try {
            String s = "238182";
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPartition(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
