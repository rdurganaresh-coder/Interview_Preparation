package com.leetcode.sliding_window_two_pointers;

class Solution3427 {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += s[i + 1] - s[Math.max(0, i - nums[i])];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3427 _tcSol = new Solution3427();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,1]");
        try {
            int[] nums = new int[]{2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraySum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,1,1,2]");
        try {
            int[] nums = new int[]{3, 1, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraySum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}
