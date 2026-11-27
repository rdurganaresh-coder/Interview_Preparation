package com.leetcode.arrays_hashing_greedy;

class Solution2708_2 {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums[1] == 0 && nums[n - 1] == 0) {
            return 0;
        }
        long ans = 1;
        int i = 0;
        while (i < n) {
            if (nums[i] < 0 && i + 1 < n && nums[i + 1] < 0) {
                ans *= nums[i] * nums[i + 1];
                i += 2;
            } else if (nums[i] <= 0) {
                i += 1;
            } else {
                ans *= nums[i];
                i += 1;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2708_2 _tcSol = new Solution2708_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,-1,-5,2,5,-9]");
        try {
            int[] nums = new int[]{3, -1, -5, 2, 5, -9};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStrength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1350");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-4,-5,-4]");
        try {
            int[] nums = new int[]{-4, -5, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStrength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}