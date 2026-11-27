package com.leetcode.dynamic_programming;

class Solution2505 {
    public long subsequenceSumOr(int[] nums) {
        long[] cnt = new long[64];
        long ans = 0;
        for (int v : nums) {
            for (int i = 0; i < 31; ++i) {
                if (((v >> i) & 1) == 1) {
                    ++cnt[i];
                }
            }
        }
        for (int i = 0; i < 63; ++i) {
            if (cnt[i] > 0) {
                ans |= 1l << i;
            }
            cnt[i + 1] += cnt[i] / 2;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2505 _tcSol = new Solution2505();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,0,3]");
        try {
            int[] nums = new int[]{2, 1, 0, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsequenceSumOr(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,0,0]");
        try {
            int[] nums = new int[]{0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsequenceSumOr(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}