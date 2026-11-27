package com.leetcode.sql_database;

class Solution1822 {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int v : nums) {
            if (v == 0) {
                return 0;
            }
            if (v < 0) {
                ans *= -1;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1822 _tcSol = new Solution1822();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-1,-2,-3,-4,3,2,1]");
        try {
            int[] nums = new int[]{-1, -2, -3, -4, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.arraySign(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,5,0,2,-3]");
        try {
            int[] nums = new int[]{1, 5, 0, 2, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.arraySign(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-1,1,-1,1,-1]");
        try {
            int[] nums = new int[]{-1, 1, -1, 1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.arraySign(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}