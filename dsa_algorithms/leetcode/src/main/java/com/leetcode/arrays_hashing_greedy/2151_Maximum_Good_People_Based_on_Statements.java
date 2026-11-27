package com.leetcode.arrays_hashing_greedy;

class Solution2151 {
    public int maximumGood(int[][] statements) {
        int ans = 0;
        for (int mask = 1; mask < 1 << statements.length; ++mask) {
            ans = Math.max(ans, check(mask, statements));
        }
        return ans;
    }

    private int check(int mask, int[][] statements) {
        int cnt = 0;
        int n = statements.length;
        for (int i = 0; i < n; ++i) {
            if (((mask >> i) & 1) == 1) {
                for (int j = 0; j < n; ++j) {
                    int v = statements[i][j];
                    if (v < 2 && ((mask >> j) & 1) != v) {
                        return 0;
                    }
                }
                ++cnt;
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2151 _tcSol = new Solution2151();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "statements = [[2,1,2],[1,2,2],[2,0,2]]");
        try {
            int[][] statements = new int[][]{new int[]{2, 1, 2}, new int[]{1, 2, 2}, new int[]{2, 0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumGood(statements)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "statements = [[2,0],[0,2]]");
        try {
            int[][] statements = new int[][]{new int[]{2, 0}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumGood(statements)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}