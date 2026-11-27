package com.leetcode.arrays_hashing_greedy;

class Solution2455 {
    public int averageValue(int[] nums) {
        int s = 0, n = 0;
        for (int x : nums) {
            if (x % 6 == 0) {
                s += x;
                ++n;
            }
        }
        return n == 0 ? 0 : s / n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2455 _tcSol = new Solution2455();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,6,10,12,15]");
        try {
            int[] nums = new int[]{1, 3, 6, 10, 12, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.averageValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,4,7,10]");
        try {
            int[] nums = new int[]{1, 2, 4, 7, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.averageValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}