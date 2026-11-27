package com.leetcode.dynamic_programming;

class Solution2545 {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2545 _tcSol = new Solution2545();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2");
        try {
            int[][] score = new int[][]{new int[]{10, 6, 9, 1}, new int[]{7, 5, 11, 2}, new int[]{4, 8, 3, 15}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.sortTheStudents(score, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[7,5,11,2],[10,6,9,1],[4,8,3,15]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "score = [[3,4],[5,6]], k = 0");
        try {
            int[][] score = new int[][]{new int[]{3, 4}, new int[]{5, 6}};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.sortTheStudents(score, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[5,6],[3,4]]");
        System.out.println();
    }
}