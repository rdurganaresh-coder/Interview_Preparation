package com.leetcode.arrays_hashing_greedy;

class Solution2974_2 {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int t = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = t;
        }
        return nums;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2974_2 _tcSol = new Solution2974_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,4,2,3]");
        try {
            int[] nums = new int[]{5, 4, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberGame(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,5,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,5]");
        try {
            int[] nums = new int[]{2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberGame(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,2]");
        System.out.println();
    }
}