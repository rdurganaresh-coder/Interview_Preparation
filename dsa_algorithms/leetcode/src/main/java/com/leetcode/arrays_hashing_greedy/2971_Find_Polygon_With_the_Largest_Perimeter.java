package com.leetcode.arrays_hashing_greedy;

class Solution2971 {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        long ans = -1;
        for (int k = 3; k <= n; ++k) {
            if (s[k - 1] > nums[k - 1]) {
                ans = Math.max(ans, s[k]);
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
        Solution2971 _tcSol = new Solution2971();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,5,5]");
        try {
            int[] nums = new int[]{5, 5, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestPerimeter(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,12,1,2,5,50,3]");
        try {
            int[] nums = new int[]{1, 12, 1, 2, 5, 50, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestPerimeter(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,5,50]");
        try {
            int[] nums = new int[]{5, 5, 50};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestPerimeter(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}