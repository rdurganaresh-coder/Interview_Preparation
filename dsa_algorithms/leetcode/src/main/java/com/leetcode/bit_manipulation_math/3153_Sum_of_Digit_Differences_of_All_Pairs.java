package com.leetcode.bit_manipulation_math;

class Solution3153 {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int m = (int) Math.floor(Math.log10(nums[0])) + 1;
        int[] cnt = new int[10];
        long ans = 0;
        for (int k = 0; k < m; ++k) {
            Arrays.fill(cnt, 0);
            for (int i = 0; i < n; ++i) {
                ++cnt[nums[i] % 10];
                nums[i] /= 10;
            }
            for (int i = 0; i < 10; ++i) {
                ans += 1L * cnt[i] * (n - cnt[i]);
            }
        }
        return ans / 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3153 _tcSol = new Solution3153();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [13,23,12]");
        try {
            int[] nums = new int[]{13, 23, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumDigitDifferences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,10,10,10]");
        try {
            int[] nums = new int[]{10, 10, 10, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumDigitDifferences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}