package com.leetcode.arrays_hashing_greedy;

class Solution1262_2 {
    public int maxSumDivThree(int[] nums) {
        final int inf = 1 << 30;
        int[] f = new int[] {0, -inf, -inf};
        for (int x : nums) {
            int[] g = f.clone();
            for (int j = 0; j < 3; ++j) {
                g[j] = Math.max(f[j], f[(j - x % 3 + 3) % 3] + x);
            }
            f = g;
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1262_2 _tcSol = new Solution1262_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,6,5,1,8]");
        try {
            int[] nums = new int[]{3, 6, 5, 1, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumDivThree(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4]");
        try {
            int[] nums = new int[]{4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumDivThree(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumDivThree(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}