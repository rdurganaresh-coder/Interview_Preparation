package com.leetcode.sql_database;

class Solution0628_2 {
    public int maximumProduct(int[] nums) {
        final int inf = 1 << 30;
        int mi1 = inf, mi2 = inf;
        int mx1 = -inf, mx2 = -inf, mx3 = -inf;
        for (int x : nums) {
            if (x < mi1) {
                mi2 = mi1;
                mi1 = x;
            } else if (x < mi2) {
                mi2 = x;
            }
            if (x > mx1) {
                mx3 = mx2;
                mx2 = mx1;
                mx1 = x;
            } else if (x > mx2) {
                mx3 = mx2;
                mx2 = x;
            } else if (x > mx3) {
                mx3 = x;
            }
        }
        return Math.max(mi1 * mi2 * mx1, mx1 * mx2 * mx3);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0628_2 _tcSol = new Solution0628_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,-3]");
        try {
            int[] nums = new int[]{1, 2, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-1,-2,-3]");
        try {
            int[] nums = new int[]{-1, -2, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-6");
        System.out.println();
    }
}