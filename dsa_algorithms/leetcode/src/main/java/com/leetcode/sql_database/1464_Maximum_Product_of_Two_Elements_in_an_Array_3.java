package com.leetcode.sql_database;

class Solution1464_3 {
    public int maxProduct(int[] nums) {
        int a = 0, b = 0;
        for (int v : nums) {
            if (v > a) {
                b = a;
                a = v;
            } else if (v > b) {
                b = v;
            }
        }
        return (a - 1) * (b - 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1464_3 _tcSol = new Solution1464_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,4,5,2]");
        try {
            int[] nums = new int[]{3, 4, 5, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,5,4,5]");
        try {
            int[] nums = new int[]{1, 5, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,7]");
        try {
            int[] nums = new int[]{3, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}