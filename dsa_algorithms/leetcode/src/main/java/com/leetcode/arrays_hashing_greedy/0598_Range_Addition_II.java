package com.leetcode.arrays_hashing_greedy;

class Solution0598 {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0598 _tcSol = new Solution0598();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 3, n = 3, ops = [[2,2],[3,3]]");
        try {
            int m = 3;
            int n = 3;
            int[][] ops = new int[][]{new int[]{2, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCount(m, n, ops)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]");
        try {
            int m = 3;
            int n = 3;
            int[][] ops = new int[][]{new int[]{2, 2}, new int[]{3, 3}, new int[]{3, 3}, new int[]{3, 3}, new int[]{2, 2}, new int[]{3, 3}, new int[]{3, 3}, new int[]{3, 3}, new int[]{2, 2}, new int[]{3, 3}, new int[]{3, 3}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCount(m, n, ops)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "m = 3, n = 3, ops = []");
        try {
            int m = 3;
            int n = 3;
            int[][] ops = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCount(m, n, ops)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}