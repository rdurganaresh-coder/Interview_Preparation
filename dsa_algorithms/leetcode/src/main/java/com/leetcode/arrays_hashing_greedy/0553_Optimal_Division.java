package com.leetcode.arrays_hashing_greedy;

class Solution0553 {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] + "";
        }
        if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder ans = new StringBuilder(nums[0] + "/(");
        for (int i = 1; i < n - 1; ++i) {
            ans.append(nums[i] + "/");
        }
        ans.append(nums[n - 1] + ")");
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0553 _tcSol = new Solution0553();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1000,100,10,2]");
        try {
            int[] nums = new int[]{1000, 100, 10, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.optimalDivision(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1000/(100/10/2)\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,4]");
        try {
            int[] nums = new int[]{2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.optimalDivision(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2/(3/4)\"");
        System.out.println();
    }
}