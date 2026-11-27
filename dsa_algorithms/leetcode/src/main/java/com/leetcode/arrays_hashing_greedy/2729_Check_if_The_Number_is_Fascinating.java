package com.leetcode.arrays_hashing_greedy;

class Solution2729 {
    public boolean isFascinating(int n) {
        String s = "" + n + (2 * n) + (3 * n);
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            if (++cnt[c - '0'] > 1) {
                return false;
            }
        }
        return cnt[0] == 0 && s.length() == 9;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2729 _tcSol = new Solution2729();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 192");
        try {
            int n = 192;
            System.out.println("  Output  : " + _tcShow(_tcSol.isFascinating(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 100");
        try {
            int n = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.isFascinating(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}