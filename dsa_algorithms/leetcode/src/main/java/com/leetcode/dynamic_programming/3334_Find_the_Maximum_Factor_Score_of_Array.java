package com.leetcode.dynamic_programming;

class Solution3334 {
    public long maxScore(int[] nums) {
        int n = nums.length;
        long[] sufGcd = new long[n + 1];
        long[] sufLcm = new long[n + 1];
        sufLcm[n] = 1;
        for (int i = n - 1; i >= 0; --i) {
            sufGcd[i] = gcd(sufGcd[i + 1], nums[i]);
            sufLcm[i] = lcm(sufLcm[i + 1], nums[i]);
        }
        long ans = sufGcd[0] * sufLcm[0];
        long preGcd = 0, preLcm = 1;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, gcd(preGcd, sufGcd[i + 1]) * lcm(preLcm, sufLcm[i + 1]));
            preGcd = gcd(preGcd, nums[i]);
            preLcm = lcm(preLcm, nums[i]);
        }
        return ans;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3334 _tcSol = new Solution3334();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,8,16]");
        try {
            int[] nums = new int[]{2, 4, 8, 16};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "64");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "60");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3]");
        try {
            int[] nums = new int[]{3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}
