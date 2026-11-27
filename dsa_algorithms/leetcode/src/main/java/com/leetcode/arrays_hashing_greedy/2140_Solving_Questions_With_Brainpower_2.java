package com.leetcode.arrays_hashing_greedy;

class Solution2140_2 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int p = questions[i][0], b = questions[i][1];
            int j = i + b + 1;
            f[i] = Math.max(f[i + 1], p + (j > n ? 0 : f[j]));
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2140_2 _tcSol = new Solution2140_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "questions = [[3,2],[4,3],[4,4],[2,5]]");
        try {
            int[][] questions = new int[][]{new int[]{3, 2}, new int[]{4, 3}, new int[]{4, 4}, new int[]{2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostPoints(questions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]");
        try {
            int[][] questions = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}, new int[]{4, 4}, new int[]{5, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostPoints(questions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}