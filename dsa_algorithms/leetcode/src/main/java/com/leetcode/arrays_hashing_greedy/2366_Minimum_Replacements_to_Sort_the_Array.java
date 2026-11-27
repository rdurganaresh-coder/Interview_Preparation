package com.leetcode.arrays_hashing_greedy;

class Solution2366 {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int mx = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] <= mx) {
                mx = nums[i];
                continue;
            }
            int k = (nums[i] + mx - 1) / mx;
            ans += k - 1;
            mx = nums[i] / k;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2366 _tcSol = new Solution2366();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,9,3]");
        try {
            int[] nums = new int[]{3, 9, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumReplacement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumReplacement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}