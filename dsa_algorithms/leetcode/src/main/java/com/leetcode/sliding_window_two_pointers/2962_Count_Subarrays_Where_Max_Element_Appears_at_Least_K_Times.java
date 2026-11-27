package com.leetcode.sliding_window_two_pointers;

class Solution2962 {
    public long countSubarrays(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        long ans = 0;
        int cnt = 0, j = 0;
        for (int x : nums) {
            while (j < n && cnt < k) {
                cnt += nums[j++] == mx ? 1 : 0;
            }
            if (cnt < k) {
                break;
            }
            ans += n - j + 1;
            cnt -= x == mx ? 1 : 0;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2962 _tcSol = new Solution2962();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,2,3,3], k = 2");
        try {
            int[] nums = new int[]{1, 3, 2, 3, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,2,1], k = 3");
        try {
            int[] nums = new int[]{1, 4, 2, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}