package com.leetcode.sliding_window_two_pointers;

class Solution3034 {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length, m = pattern.length;
        int ans = 0;
        for (int i = 0; i < n - m; ++i) {
            int ok = 1;
            for (int k = 0; k < m && ok == 1; ++k) {
                if (f(nums[i + k], nums[i + k + 1]) != pattern[k]) {
                    ok = 0;
                }
            }
            ans += ok;
        }
        return ans;
    }

    private int f(int a, int b) {
        return a == b ? 0 : (a < b ? 1 : -1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3034 _tcSol = new Solution3034();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,6], pattern = [1,1]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6};
            int[] pattern = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countMatchingSubarrays(nums, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,4,1,3,5,5,3], pattern = [1,0,-1]");
        try {
            int[] nums = new int[]{1, 4, 4, 1, 3, 5, 5, 3};
            int[] pattern = new int[]{1, 0, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countMatchingSubarrays(nums, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}