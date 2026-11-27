package com.leetcode.arrays_hashing_greedy;

class Solution1814 {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            int y = x - rev(x);
            cnt.merge(y, 1, Integer::sum);
        }
        final int mod = (int) 1e9 + 7;
        long ans = 0;
        for (int v : cnt.values()) {
            ans = (ans + (long) v * (v - 1) / 2) % mod;
        }
        return (int) ans;
    }

    private int rev(int x) {
        int y = 0;
        for (; x > 0; x /= 10) {
            y = y * 10 + x % 10;
        }
        return y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1814 _tcSol = new Solution1814();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [42,11,1,97]");
        try {
            int[] nums = new int[]{42, 11, 1, 97};
            System.out.println("  Output  : " + _tcShow(_tcSol.countNicePairs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [13,10,35,24,76]");
        try {
            int[] nums = new int[]{13, 10, 35, 24, 76};
            System.out.println("  Output  : " + _tcShow(_tcSol.countNicePairs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}