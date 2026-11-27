package com.leetcode.sliding_window_two_pointers;

class Solution1330 {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int s = 0;
        for (int i = 0; i < n - 1; ++i) {
            s += Math.abs(nums[i] - nums[i + 1]);
        }
        int ans = s;
        for (int i = 0; i < n - 1; ++i) {
            ans = Math.max(
                ans, s + Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            ans = Math.max(
                ans, s + Math.abs(nums[n - 1] - nums[i]) - Math.abs(nums[i] - nums[i + 1]));
        }
        int[] dirs = {1, -1, -1, 1, 1};
        final int inf = 1 << 30;
        for (int k = 0; k < 4; ++k) {
            int k1 = dirs[k], k2 = dirs[k + 1];
            int mx = -inf, mi = inf;
            for (int i = 0; i < n - 1; ++i) {
                int a = k1 * nums[i] + k2 * nums[i + 1];
                int b = Math.abs(nums[i] - nums[i + 1]);
                mx = Math.max(mx, a - b);
                mi = Math.min(mi, a + b);
            }
            ans = Math.max(ans, s + Math.max(0, mx - mi));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1330 _tcSol = new Solution1330();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,1,5,4]");
        try {
            int[] nums = new int[]{2, 3, 1, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValueAfterReverse(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,9,24,2,1,10]");
        try {
            int[] nums = new int[]{2, 4, 9, 24, 2, 1, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValueAfterReverse(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "68");
        System.out.println();
    }
}