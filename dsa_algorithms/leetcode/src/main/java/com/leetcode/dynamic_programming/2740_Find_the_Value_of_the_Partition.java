package com.leetcode.dynamic_programming;

class Solution2740 {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = 1 << 30;
        for (int i = 1; i < nums.length; ++i) {
            ans = Math.min(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2740 _tcSol = new Solution2740();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,2,4]");
        try {
            int[] nums = new int[]{1, 3, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findValueOfPartition(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [100,1,10]");
        try {
            int[] nums = new int[]{100, 1, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.findValueOfPartition(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}