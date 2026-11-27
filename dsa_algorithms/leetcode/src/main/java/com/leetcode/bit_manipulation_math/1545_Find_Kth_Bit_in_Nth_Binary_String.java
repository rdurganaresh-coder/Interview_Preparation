package com.leetcode.bit_manipulation_math;

class Solution1545 {
    public char findKthBit(int n, int k) {
        return (char) ('0' + dfs(n, k));
    }

    private int dfs(int n, int k) {
        if (k == 1) {
            return 0;
        }
        if ((k & (k - 1)) == 0) {
            return 1;
        }
        int m = 1 << n;
        if (k * 2 < m - 1) {
            return dfs(n - 1, k);
        }
        return dfs(n - 1, m - k) ^ 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1545 _tcSol = new Solution1545();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 1");
        try {
            int n = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKthBit(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, k = 11");
        try {
            int n = 4;
            int k = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKthBit(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1\"");
        System.out.println();
    }
}