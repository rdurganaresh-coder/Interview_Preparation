package com.leetcode.arrays_hashing_greedy;

class Solution2285 {
    public long maximumImportance(int n, int[][] roads) {
        int[] deg = new int[n];
        for (int[] r : roads) {
            ++deg[r[0]];
            ++deg[r[1]];
        }
        Arrays.sort(deg);
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += (long) (i + 1) * deg[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2285 _tcSol = new Solution2285();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]");
        try {
            int n = 5;
            int[][] roads = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumImportance(n, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "43");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, roads = [[0,3],[2,4],[1,3]]");
        try {
            int n = 5;
            int[][] roads = new int[][]{new int[]{0, 3}, new int[]{2, 4}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumImportance(n, roads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}