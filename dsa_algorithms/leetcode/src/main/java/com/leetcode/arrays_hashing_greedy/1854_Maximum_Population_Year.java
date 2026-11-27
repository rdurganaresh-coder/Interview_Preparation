package com.leetcode.arrays_hashing_greedy;

class Solution1854 {
    public int maximumPopulation(int[][] logs) {
        int[] d = new int[101];
        final int offset = 1950;
        for (var log : logs) {
            int a = log[0] - offset;
            int b = log[1] - offset;
            ++d[a];
            --d[b];
        }
        int s = 0, mx = 0;
        int j = 0;
        for (int i = 0; i < d.length; ++i) {
            s += d[i];
            if (mx < s) {
                mx = s;
                j = i;
            }
        }
        return j + offset;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1854 _tcSol = new Solution1854();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "logs = [[1993,1999],[2000,2010]]");
        try {
            int[][] logs = new int[][]{new int[]{1993, 1999}, new int[]{2000, 2010}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumPopulation(logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1993");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "logs = [[1950,1961],[1960,1971],[1970,1981]]");
        try {
            int[][] logs = new int[][]{new int[]{1950, 1961}, new int[]{1960, 1971}, new int[]{1970, 1981}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumPopulation(logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1960");
        System.out.println();
    }
}