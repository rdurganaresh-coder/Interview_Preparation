package com.leetcode.arrays_hashing_greedy;

class Solution1838_2 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        long s = 0;
        for (int i = 1, j = 0; i < nums.length; ++i) {
            s += 1L * (nums[i] - nums[i - 1]) * (i - j);
            while (s > k) {
                s -= nums[i] - nums[j++];
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1838_2 _tcSol = new Solution1838_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,4], k = 5");
        try {
            int[] nums = new int[]{1, 2, 4};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFrequency(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,8,13], k = 5");
        try {
            int[] nums = new int[]{1, 4, 8, 13};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFrequency(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,9,6], k = 2");
        try {
            int[] nums = new int[]{3, 9, 6};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFrequency(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}