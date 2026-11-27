package com.leetcode.sliding_window_two_pointers;

class Solution3171 {
    public int minimumDifference(int[] nums, int k) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int m = 32 - Integer.numberOfLeadingZeros(mx);
        int[] cnt = new int[m];
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = 0, s = 0; j < n; ++j) {
            s |= nums[j];
            ans = Math.min(ans, Math.abs(s - k));
            for (int h = 0; h < m; ++h) {
                if ((nums[j] >> h & 1) == 1) {
                    ++cnt[h];
                }
            }
            while (i < j && s > k) {
                for (int h = 0; h < m; ++h) {
                    if ((nums[i] >> h & 1) == 1 && --cnt[h] == 0) {
                        s ^= 1 << h;
                    }
                }
                ++i;
                ans = Math.min(ans, Math.abs(s - k));
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
        Solution3171 _tcSol = new Solution3171();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,4,5], k = 3");
        try {
            int[] nums = new int[]{1, 2, 4, 5};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,1,3], k = 2");
        try {
            int[] nums = new int[]{1, 3, 1, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1], k = 10");
        try {
            int[] nums = new int[]{1};
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}