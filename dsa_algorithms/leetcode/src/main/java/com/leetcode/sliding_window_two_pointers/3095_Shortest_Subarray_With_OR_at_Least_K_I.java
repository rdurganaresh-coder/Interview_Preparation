package com.leetcode.sliding_window_two_pointers;

class Solution3095 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[32];
        int ans = n + 1;
        for (int i = 0, j = 0, s = 0; j < n; ++j) {
            s |= nums[j];
            for (int h = 0; h < 32; ++h) {
                if ((nums[j] >> h & 1) == 1) {
                    ++cnt[h];
                }
            }
            for (; s >= k && i <= j; ++i) {
                ans = Math.min(ans, j - i + 1);
                for (int h = 0; h < 32; ++h) {
                    if ((nums[i] >> h & 1) == 1) {
                        if (--cnt[h] == 0) {
                            s ^= 1 << h;
                        }
                    }
                }
            }
        }
        return ans > n ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3095 _tcSol = new Solution3095();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3], k = 2");
        try {
            int[] nums = new int[]{1, 2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSubarrayLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1,8], k = 10");
        try {
            int[] nums = new int[]{2, 1, 8};
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSubarrayLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2], k = 0");
        try {
            int[] nums = new int[]{1, 2};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSubarrayLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}