package com.leetcode.arrays_hashing_greedy;

class Solution1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 100000;
        for (int i = 0; i < nums.length - k + 1; ++i) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1984 _tcSol = new Solution1984();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [90], k = 1");
        try {
            int[] nums = new int[]{90};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [9,4,1,7], k = 2");
        try {
            int[] nums = new int[]{9, 4, 1, 7};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}