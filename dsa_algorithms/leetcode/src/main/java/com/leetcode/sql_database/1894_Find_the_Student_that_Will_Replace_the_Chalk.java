package com.leetcode.sql_database;

class Solution1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long s = 0;
        for (int x : chalk) {
            s += x;
        }
        k %= s;
        for (int i = 0;; ++i) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1894 _tcSol = new Solution1894();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "chalk = [5,1,5], k = 22");
        try {
            int[] chalk = new int[]{5, 1, 5};
            int k = 22;
            System.out.println("  Output  : " + _tcShow(_tcSol.chalkReplacer(chalk, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "chalk = [3,4,1,2], k = 25");
        try {
            int[] chalk = new int[]{3, 4, 1, 2};
            int k = 25;
            System.out.println("  Output  : " + _tcShow(_tcSol.chalkReplacer(chalk, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}