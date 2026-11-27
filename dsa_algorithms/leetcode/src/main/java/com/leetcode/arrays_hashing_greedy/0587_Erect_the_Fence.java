package com.leetcode.arrays_hashing_greedy;

class Solution0587 {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        Arrays.sort(trees, (a, b) -> { return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]; });
        boolean[] vis = new boolean[n];
        int[] stk = new int[n + 10];
        int cnt = 1;
        for (int i = 1; i < n; ++i) {
            while (cnt > 1 && cross(trees[stk[cnt - 1]], trees[stk[cnt - 2]], trees[i]) < 0) {
                vis[stk[--cnt]] = false;
            }
            vis[i] = true;
            stk[cnt++] = i;
        }
        int m = cnt;
        for (int i = n - 1; i >= 0; --i) {
            if (vis[i]) {
                continue;
            }
            while (cnt > m && cross(trees[stk[cnt - 1]], trees[stk[cnt - 2]], trees[i]) < 0) {
                --cnt;
            }
            stk[cnt++] = i;
        }
        int[][] ans = new int[cnt - 1][2];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = trees[stk[i]];
        }
        return ans;
    }

    private int cross(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - b[1]) - (b[1] - a[1]) * (c[0] - b[0]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0587 _tcSol = new Solution0587();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "trees = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]");
        try {
            int[][] trees = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{2, 0}, new int[]{2, 4}, new int[]{3, 3}, new int[]{4, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.outerTrees(trees)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1],[2,0],[4,2],[3,3],[2,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "trees = [[1,2],[2,2],[4,2]]");
        try {
            int[][] trees = new int[][]{new int[]{1, 2}, new int[]{2, 2}, new int[]{4, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.outerTrees(trees)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[4,2],[2,2],[1,2]]");
        System.out.println();
    }
}