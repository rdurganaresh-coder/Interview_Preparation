package com.leetcode.dynamic_programming;

class Solution1406 {
    private int[] stoneValue;
    private Integer[] f;
    private int n;

    public String stoneGameIII(int[] stoneValue) {
        this.stoneValue = stoneValue;
        this.n = stoneValue.length;
        this.f = new Integer[n];

        int res = dfs(0);

        if (res == 0) {
            return "Tie";
        }
        return res > 0 ? "Alice" : "Bob";
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }

        if (f[i] != null) {
            return f[i];
        }

        int ans = Integer.MIN_VALUE;
        int s = 0;

        for (int j = i; j < i + 3 && j < n; j++) {
            s += stoneValue[j];
            ans = Math.max(ans, s - dfs(j + 1));
        }

        return f[i] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1406 _tcSol = new Solution1406();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stoneValue = [1,2,3,7]");
        try {
            int[] stoneValue = new int[]{1, 2, 3, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameIII(stoneValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Bob\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stoneValue = [1,2,3,-9]");
        try {
            int[] stoneValue = new int[]{1, 2, 3, -9};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameIII(stoneValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Alice\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "stoneValue = [1,2,3,6]");
        try {
            int[] stoneValue = new int[]{1, 2, 3, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameIII(stoneValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Tie\"");
        System.out.println();
    }
}
