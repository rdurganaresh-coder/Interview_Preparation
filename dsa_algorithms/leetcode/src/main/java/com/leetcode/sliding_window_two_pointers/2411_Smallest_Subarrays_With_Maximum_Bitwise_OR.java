package com.leetcode.sliding_window_two_pointers;

class Solution2411 {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] f = new int[32];
        Arrays.fill(f, -1);
        for (int i = n - 1; i >= 0; --i) {
            int t = 1;
            for (int j = 0; j < 32; ++j) {
                if (((nums[i] >> j) & 1) == 1) {
                    f[j] = i;
                } else if (f[j] != -1) {
                    t = Math.max(t, f[j] - i + 1);
                }
            }
            ans[i] = t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2411 _tcSol = new Solution2411();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,2,1,3]");
        try {
            int[] nums = new int[]{1, 0, 2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,2,2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2]");
        try {
            int[] nums = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1]");
        System.out.println();
    }
}