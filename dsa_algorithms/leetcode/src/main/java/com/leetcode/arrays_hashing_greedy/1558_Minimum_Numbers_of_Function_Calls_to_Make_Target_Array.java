package com.leetcode.arrays_hashing_greedy;

class Solution1558 {
    public int minOperations(int[] nums) {
        int ans = 0;
        int mx = 0;
        for (int v : nums) {
            mx = Math.max(mx, v);
            ans += Integer.bitCount(v);
        }
        ans += Integer.toBinaryString(mx).length() - 1;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1558 _tcSol = new Solution1558();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,5]");
        try {
            int[] nums = new int[]{1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2]");
        try {
            int[] nums = new int[]{2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [4,2,5]");
        try {
            int[] nums = new int[]{4, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}