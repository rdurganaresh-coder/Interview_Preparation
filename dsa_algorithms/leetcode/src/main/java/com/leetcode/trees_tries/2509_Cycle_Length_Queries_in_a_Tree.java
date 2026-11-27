package com.leetcode.trees_tries;

class Solution2509 {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int a = queries[i][0], b = queries[i][1];
            int t = 1;
            while (a != b) {
                if (a > b) {
                    a >>= 1;
                } else {
                    b >>= 1;
                }
                ++t;
            }
            ans[i] = t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2509 _tcSol = new Solution2509();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, queries = [[5,3],[4,7],[2,3]]");
        try {
            int n = 3;
            int[][] queries = new int[][]{new int[]{5, 3}, new int[]{4, 7}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.cycleLengthQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,5,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, queries = [[1,2]]");
        try {
            int n = 2;
            int[][] queries = new int[][]{new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.cycleLengthQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2]");
        System.out.println();
    }
}