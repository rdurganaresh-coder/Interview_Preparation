package com.leetcode.arrays_hashing_greedy;

class Solution2924 {
    public int findChampion(int n, int[][] edges) {
        int[] indeg = new int[n];
        for (var e : edges) {
            ++indeg[e[1]];
        }
        int ans = -1, cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                ++cnt;
                ans = i;
            }
        }
        return cnt == 1 ? ans : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2924 _tcSol = new Solution2924();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1],[1,2]]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findChampion(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, edges = [[0,2],[1,3],[1,2]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findChampion(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}