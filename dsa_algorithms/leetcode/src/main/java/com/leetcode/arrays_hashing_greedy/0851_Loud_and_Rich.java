package com.leetcode.arrays_hashing_greedy;

class Solution0851 {
    private List<Integer>[] g;
    private int n;
    private int[] quiet;
    private int[] ans;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        n = quiet.length;
        this.quiet = quiet;
        g = new List[n];
        ans = new int[n];
        Arrays.fill(ans, -1);
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var r : richer) {
            g[r[1]].add(r[0]);
        }
        for (int i = 0; i < n; ++i) {
            dfs(i);
        }
        return ans;
    }

    private void dfs(int i) {
        if (ans[i] != -1) {
            return;
        }
        ans[i] = i;
        for (int j : g[i]) {
            dfs(j);
            if (quiet[ans[j]] < quiet[ans[i]]) {
                ans[i] = ans[j];
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0851 _tcSol = new Solution0851();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]");
        try {
            int[][] richer = new int[][]{new int[]{1, 0}, new int[]{2, 1}, new int[]{3, 1}, new int[]{3, 7}, new int[]{4, 3}, new int[]{5, 3}, new int[]{6, 3}};
            int[] quiet = new int[]{3, 2, 5, 4, 6, 1, 7, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.loudAndRich(richer, quiet)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,5,2,5,4,5,6,7]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "richer = [], quiet = [0]");
        try {
            int[][] richer = new int[][]{};
            int[] quiet = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.loudAndRich(richer, quiet)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}