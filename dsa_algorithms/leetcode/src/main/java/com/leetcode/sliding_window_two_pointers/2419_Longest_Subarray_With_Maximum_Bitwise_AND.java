package com.leetcode.sliding_window_two_pointers;

class Solution2419 {
    public int longestSubarray(int[] nums) {
        int mx = Arrays.stream(nums).max().getAsInt();
        int ans = 0, cnt = 0;
        for (int x : nums) {
            if (x == mx) {
                ans = Math.max(ans, ++cnt);
            } else {
                cnt = 0;
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
        Solution2419 _tcSol = new Solution2419();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,3,2,2]");
        try {
            int[] nums = new int[]{1, 2, 3, 3, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
