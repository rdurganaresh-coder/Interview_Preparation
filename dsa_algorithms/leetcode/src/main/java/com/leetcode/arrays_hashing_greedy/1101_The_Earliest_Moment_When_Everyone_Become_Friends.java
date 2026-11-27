package com.leetcode.arrays_hashing_greedy;

class Solution1101 {
    private int[] p;

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (int[] log : logs) {
            int t = log[0], x = log[1], y = log[2];
            if (find(x) == find(y)) {
                continue;
            }
            p[find(x)] = find(y);
            if (--n == 1) {
                return t;
            }
        }
        return -1;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1101 _tcSol = new Solution1101();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], n = 6");
        try {
            int[][] logs = new int[][]{new int[]{20190101, 0, 1}, new int[]{20190104, 3, 4}, new int[]{20190107, 2, 3}, new int[]{20190211, 1, 5}, new int[]{20190224, 2, 4}, new int[]{20190301, 0, 3}, new int[]{20190312, 1, 2}, new int[]{20190322, 4, 5}};
            int n = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.earliestAcq(logs, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20190301");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "logs = [[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]], n = 4");
        try {
            int[][] logs = new int[][]{new int[]{0, 2, 0}, new int[]{1, 0, 1}, new int[]{3, 0, 3}, new int[]{4, 1, 2}, new int[]{7, 3, 1}};
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.earliestAcq(logs, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}