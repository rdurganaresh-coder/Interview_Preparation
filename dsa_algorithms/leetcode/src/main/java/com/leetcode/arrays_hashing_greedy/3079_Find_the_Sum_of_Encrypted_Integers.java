package com.leetcode.arrays_hashing_greedy;

class Solution3079 {
    public int sumOfEncryptedInt(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans += encrypt(x);
        }
        return ans;
    }

    private int encrypt(int x) {
        int mx = 0, p = 0;
        for (; x > 0; x /= 10) {
            mx = Math.max(mx, x % 10);
            p = p * 10 + 1;
        }
        return mx * p;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3079 _tcSol = new Solution3079();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfEncryptedInt(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,21,31]");
        try {
            int[] nums = new int[]{10, 21, 31};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfEncryptedInt(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "66");
        System.out.println();
    }
}