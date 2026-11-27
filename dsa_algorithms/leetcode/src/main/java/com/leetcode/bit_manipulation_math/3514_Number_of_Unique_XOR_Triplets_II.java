package com.leetcode.bit_manipulation_math;

class Solution3514 {
    public int uniqueXorTriplets(int[] nums) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        mx <<= 1;

        boolean[] st = new boolean[mx];
        for (int a : nums) {
            for (int b : nums) {
                st[a ^ b] = true;
            }
        }

        int[] s = new int[mx];
        for (int ab = 0; ab < mx; ab++) {
            if (st[ab]) {
                for (int c : nums) {
                    s[ab ^ c] = 1;
                }
            }
        }

        int ans = 0;
        for (int v : s) {
            ans += v;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3514 _tcSol = new Solution3514();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3]");
        try {
            int[] nums = new int[]{1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueXorTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,7,8,9]");
        try {
            int[] nums = new int[]{6, 7, 8, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueXorTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}