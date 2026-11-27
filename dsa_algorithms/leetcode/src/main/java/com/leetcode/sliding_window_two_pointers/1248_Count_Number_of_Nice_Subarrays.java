package com.leetcode.sliding_window_two_pointers;

class Solution1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v & 1;
            if (t - k >= 0) {
                ans += cnt[t - k];
            }
            cnt[t]++;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1248 _tcSol = new Solution1248();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,2,1,1], k = 3");
        try {
            int[] nums = new int[]{1, 1, 2, 1, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,6], k = 1");
        try {
            int[] nums = new int[]{2, 4, 6};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,2,2,1,2,2,1,2,2,2], k = 2");
        try {
            int[] nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}