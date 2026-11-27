package com.leetcode.arrays_hashing_greedy;

class Solution2733 {
    public int findNonMinOrMax(int[] nums) {
        int mi = 100, mx = 0;
        for (int x : nums) {
            mi = Math.min(mi, x);
            mx = Math.max(mx, x);
        }
        for (int x : nums) {
            if (x != mi && x != mx) {
                return x;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2733 _tcSol = new Solution2733();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,1,4]");
        try {
            int[] nums = new int[]{3, 2, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findNonMinOrMax(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2]");
        try {
            int[] nums = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findNonMinOrMax(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,1,3]");
        try {
            int[] nums = new int[]{2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findNonMinOrMax(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}