package com.leetcode.dynamic_programming;

class Solution0561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0561 _tcSol = new Solution0561();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,3,2]");
        try {
            int[] nums = new int[]{1, 4, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayPairSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,2,6,5,1,2]");
        try {
            int[] nums = new int[]{6, 2, 6, 5, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayPairSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}