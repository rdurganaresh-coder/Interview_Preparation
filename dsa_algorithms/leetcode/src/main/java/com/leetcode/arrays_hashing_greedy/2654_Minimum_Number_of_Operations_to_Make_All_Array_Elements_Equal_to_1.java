package com.leetcode.arrays_hashing_greedy;

class Solution2654 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int x : nums) {
            if (x == 1) {
                ++cnt;
            }
        }
        if (cnt > 0) {
            return n - cnt;
        }
        int mi = n + 1;
        for (int i = 0; i < n; ++i) {
            int g = 0;
            for (int j = i; j < n; ++j) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    mi = Math.min(mi, j - i + 1);
                }
            }
        }
        return mi > n ? -1 : n - 1 + mi - 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2654 _tcSol = new Solution2654();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,6,3,4]");
        try {
            int[] nums = new int[]{2, 6, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,10,6,14]");
        try {
            int[] nums = new int[]{2, 10, 6, 14};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}