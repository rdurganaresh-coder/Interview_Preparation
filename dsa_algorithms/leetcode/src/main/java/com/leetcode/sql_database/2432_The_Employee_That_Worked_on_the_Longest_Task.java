package com.leetcode.sql_database;

class Solution2432 {
    public int hardestWorker(int n, int[][] logs) {
        int ans = 0;
        int last = 0, mx = 0;
        for (int[] log : logs) {
            int uid = log[0], t = log[1];
            t -= last;
            if (mx < t || (mx == t && ans > uid)) {
                ans = uid;
                mx = t;
            }
            last += t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2432 _tcSol = new Solution2432();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 10, logs = [[0,3],[2,5],[0,9],[1,15]]");
        try {
            int n = 10;
            int[][] logs = new int[][]{new int[]{0, 3}, new int[]{2, 5}, new int[]{0, 9}, new int[]{1, 15}};
            System.out.println("  Output  : " + _tcShow(_tcSol.hardestWorker(n, logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 26, logs = [[1,1],[3,7],[2,12],[7,17]]");
        try {
            int n = 26;
            int[][] logs = new int[][]{new int[]{1, 1}, new int[]{3, 7}, new int[]{2, 12}, new int[]{7, 17}};
            System.out.println("  Output  : " + _tcShow(_tcSol.hardestWorker(n, logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, logs = [[0,10],[1,20]]");
        try {
            int n = 2;
            int[][] logs = new int[][]{new int[]{0, 10}, new int[]{1, 20}};
            System.out.println("  Output  : " + _tcShow(_tcSol.hardestWorker(n, logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}