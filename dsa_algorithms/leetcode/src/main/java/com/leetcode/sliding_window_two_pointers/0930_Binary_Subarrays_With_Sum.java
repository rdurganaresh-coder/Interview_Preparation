package com.leetcode.sliding_window_two_pointers;

class Solution0930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] cnt = new int[nums.length + 1];
        cnt[0] = 1;
        int ans = 0, s = 0;
        for (int v : nums) {
            s += v;
            if (s - goal >= 0) {
                ans += cnt[s - goal];
            }
            ++cnt[s];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0930 _tcSol = new Solution0930();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,1,0,1], goal = 2");
        try {
            int[] nums = new int[]{1, 0, 1, 0, 1};
            int goal = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubarraysWithSum(nums, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,0,0,0,0], goal = 0");
        try {
            int[] nums = new int[]{0, 0, 0, 0, 0};
            int goal = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubarraysWithSum(nums, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}