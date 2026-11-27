package com.leetcode.arrays_hashing_greedy;

class Solution2289 {
    public int totalSteps(int[] nums) {
        Deque<Integer> stk = new ArrayDeque<>();
        int ans = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && nums[i] > nums[stk.peek()]) {
                dp[i] = Math.max(dp[i] + 1, dp[stk.pop()]);
                ans = Math.max(ans, dp[i]);
            }
            stk.push(i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2289 _tcSol = new Solution2289();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,3,4,4,7,3,6,11,8,5,11]");
        try {
            int[] nums = new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalSteps(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,5,7,7,13]");
        try {
            int[] nums = new int[]{4, 5, 7, 7, 13};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalSteps(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}