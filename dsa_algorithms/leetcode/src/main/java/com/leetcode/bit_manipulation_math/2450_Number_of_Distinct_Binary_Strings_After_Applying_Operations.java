package com.leetcode.bit_manipulation_math;

class Solution2450 {
    public static final int MOD = (int) 1e9 + 7;

    public int countDistinctStrings(String s, int k) {
        int ans = 1;
        for (int i = 0; i < s.length() - k + 1; ++i) {
            ans = (ans * 2) % MOD;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2450 _tcSol = new Solution2450();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1001\", k = 3");
        try {
            String s = "1001";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countDistinctStrings(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"10110\", k = 5");
        try {
            String s = "10110";
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countDistinctStrings(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}