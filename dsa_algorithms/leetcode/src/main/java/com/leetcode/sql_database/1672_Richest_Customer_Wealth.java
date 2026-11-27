package com.leetcode.sql_database;

class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (var e : accounts) {
            // int s = Arrays.stream(e).sum();
            int s = 0;
            for (int v : e) {
                s += v;
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1672 _tcSol = new Solution1672();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "accounts = [[1,2,3],[3,2,1]]");
        try {
            int[][] accounts = new int[][]{new int[]{1, 2, 3}, new int[]{3, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumWealth(accounts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "accounts = [[1,5],[7,3],[3,5]]");
        try {
            int[][] accounts = new int[][]{new int[]{1, 5}, new int[]{7, 3}, new int[]{3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumWealth(accounts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "accounts = [[2,8,7],[7,1,3],[1,9,5]]");
        try {
            int[][] accounts = new int[][]{new int[]{2, 8, 7}, new int[]{7, 1, 3}, new int[]{1, 9, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumWealth(accounts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();
    }
}