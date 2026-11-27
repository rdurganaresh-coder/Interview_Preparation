package com.leetcode.arrays_hashing_greedy;

class Solution0477 {
    public int totalHammingDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 32; ++i) {
            int a = 0;
            for (int x : nums) {
                a += (x >> i & 1);
            }
            int b = n - a;
            ans += a * b;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0477 _tcSol = new Solution0477();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,14,2]");
        try {
            int[] nums = new int[]{4, 14, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalHammingDistance(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,14,4]");
        try {
            int[] nums = new int[]{4, 14, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalHammingDistance(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}