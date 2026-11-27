package com.leetcode.arrays_hashing_greedy;

class Solution2210 {
    public int countHillValley(int[] nums) {
        int ans = 0, j = 0;
        for (int i = 1; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] > nums[j] && nums[i] > nums[i + 1]) {
                ++ans;
            }
            if (nums[i] < nums[j] && nums[i] < nums[i + 1]) {
                ++ans;
            }
            j = i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2210 _tcSol = new Solution2210();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,1,1,6,5]");
        try {
            int[] nums = new int[]{2, 4, 1, 1, 6, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.countHillValley(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,6,5,5,4,1]");
        try {
            int[] nums = new int[]{6, 6, 5, 5, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countHillValley(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}