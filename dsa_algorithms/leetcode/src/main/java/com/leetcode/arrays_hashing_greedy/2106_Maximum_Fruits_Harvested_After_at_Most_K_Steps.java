package com.leetcode.arrays_hashing_greedy;

class Solution2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0, s = 0;
        for (int i = 0, j = 0; j < fruits.length; ++j) {
            int pj = fruits[j][0], fj = fruits[j][1];
            s += fj;
            while (i <= j
                && pj - fruits[i][0]
                        + Math.min(Math.abs(startPos - fruits[i][0]), Math.abs(startPos - pj))
                    > k) {
                s -= fruits[i++][1];
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
        Solution2106 _tcSol = new Solution2106();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4");
        try {
            int[][] fruits = new int[][]{new int[]{2, 8}, new int[]{6, 3}, new int[]{8, 6}};
            int startPos = 5;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTotalFruits(fruits, startPos, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4");
        try {
            int[][] fruits = new int[][]{new int[]{0, 9}, new int[]{4, 1}, new int[]{5, 7}, new int[]{6, 2}, new int[]{7, 4}, new int[]{10, 9}};
            int startPos = 5;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTotalFruits(fruits, startPos, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2");
        try {
            int[][] fruits = new int[][]{new int[]{0, 3}, new int[]{6, 4}, new int[]{8, 5}};
            int startPos = 3;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTotalFruits(fruits, startPos, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}