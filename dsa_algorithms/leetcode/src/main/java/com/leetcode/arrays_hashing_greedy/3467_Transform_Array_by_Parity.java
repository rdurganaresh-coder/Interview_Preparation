package com.leetcode.arrays_hashing_greedy;

class Solution3467 {
    public int[] transformArray(int[] nums) {
        int even = 0;
        for (int x : nums) {
            even += (x & 1 ^ 1);
        }
        for (int i = 0; i < even; ++i) {
            nums[i] = 0;
        }
        for (int i = even; i < nums.length; ++i) {
            nums[i] = 1;
        }
        return nums;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3467 _tcSol = new Solution3467();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,2,1]");
        try {
            int[] nums = new int[]{4, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.transformArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,5,1,4,2]");
        try {
            int[] nums = new int[]{1, 5, 1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.transformArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,1,1,1]");
        System.out.println();
    }
}
