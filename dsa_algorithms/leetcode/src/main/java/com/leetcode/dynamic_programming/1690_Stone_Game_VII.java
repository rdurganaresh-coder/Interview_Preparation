package com.leetcode.dynamic_programming;

class Solution1690 {
    private int[] s;
    private Integer[][] f;

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        s = new int[n + 1];
        f = new Integer[n][n];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + stones[i];
        }
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int a = s[j + 1] - s[i + 1] - dfs(i + 1, j);
        int b = s[j] - s[i] - dfs(i, j - 1);
        return f[i][j] = Math.max(a, b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1690 _tcSol = new Solution1690();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [5,3,1,4,2]");
        try {
            int[] stones = new int[]{5, 3, 1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameVII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [7,90,5,1,100,10,10,2]");
        try {
            int[] stones = new int[]{7, 90, 5, 1, 100, 10, 10, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameVII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "122");
        System.out.println();
    }
}
