package com.leetcode.arrays_hashing_greedy;

class Solution3524 {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] f = new long[k];
        for (int x : nums) {
            long[] g = new long[k];
            for (int r = 0; r < k; ++r) {
                g[(int) (1L * r * x % k)] += f[r];
            }
            g[x % k] += 1;
            for (int r = 0; r < k; ++r) {
                ans[r] += g[r];
            }
            f = g;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3524 _tcSol = new Solution3524();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,2,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,4,8,16,32], k = 4");
        try {
            int[] nums = new int[]{1, 2, 4, 8, 16, 32};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[18,1,2,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,2,1,1], k = 2");
        try {
            int[] nums = new int[]{1, 1, 2, 1, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,6]");
        System.out.println();
    }
}
