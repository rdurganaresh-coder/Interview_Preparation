package com.leetcode.dynamic_programming;

class Solution3290 {
    private Long[][] f;
    private int[] a;
    private int[] b;

    public long maxScore(int[] a, int[] b) {
        f = new Long[a.length][b.length];
        this.a = a;
        this.b = b;
        return dfs(0, 0);
    }

    private long dfs(int i, int j) {
        if (j >= b.length) {
            return i >= a.length ? 0 : Long.MIN_VALUE / 2;
        }
        if (i >= a.length) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        return f[i][j] = Math.max(dfs(i, j + 1), 1L * a[i] * b[j] + dfs(i + 1, j + 1));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3290 _tcSol = new Solution3290();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = [3,2,5,6], b = [2,-6,4,-5,-3,2,-7]");
        try {
            int[] a = new int[]{3, 2, 5, 6};
            int[] b = new int[]{2, -6, 4, -5, -3, 2, -7};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "26");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = [-1,4,5,-2], b = [-5,-1,-3,-2,-4]");
        try {
            int[] a = new int[]{-1, 4, 5, -2};
            int[] b = new int[]{-5, -1, -3, -2, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
