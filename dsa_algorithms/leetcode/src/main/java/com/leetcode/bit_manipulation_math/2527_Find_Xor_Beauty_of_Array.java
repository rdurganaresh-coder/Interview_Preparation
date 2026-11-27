package com.leetcode.bit_manipulation_math;

class Solution2527 {
    public int xorBeauty(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2527 _tcSol = new Solution2527();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4]");
        try {
            int[] nums = new int[]{1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.xorBeauty(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [15,45,20,2,34,35,5,44,32,30]");
        try {
            int[] nums = new int[]{15, 45, 20, 2, 34, 35, 5, 44, 32, 30};
            System.out.println("  Output  : " + _tcShow(_tcSol.xorBeauty(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "34");
        System.out.println();
    }
}