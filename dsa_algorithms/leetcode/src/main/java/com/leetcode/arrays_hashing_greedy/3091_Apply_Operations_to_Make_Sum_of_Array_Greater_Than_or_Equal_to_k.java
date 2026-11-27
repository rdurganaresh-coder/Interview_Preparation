package com.leetcode.arrays_hashing_greedy;

class Solution3091 {
    public int minOperations(int k) {
        int ans = k;
        for (int a = 0; a < k; ++a) {
            int x = a + 1;
            int b = (k + x - 1) / x - 1;
            ans = Math.min(ans, a + b);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3091 _tcSol = new Solution3091();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 11");
        try {
            int k = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 1");
        try {
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}