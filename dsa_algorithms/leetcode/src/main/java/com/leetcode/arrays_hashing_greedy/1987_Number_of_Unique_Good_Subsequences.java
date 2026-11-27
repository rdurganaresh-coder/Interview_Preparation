package com.leetcode.arrays_hashing_greedy;

class Solution1987 {
    public int numberOfUniqueGoodSubsequences(String binary) {
        final int mod = (int) 1e9 + 7;
        int f = 0, g = 0;
        int ans = 0;
        for (int i = 0; i < binary.length(); ++i) {
            if (binary.charAt(i) == '0') {
                g = (g + f) % mod;
                ans = 1;
            } else {
                f = (f + g + 1) % mod;
            }
        }
        ans = (ans + f + g) % mod;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1987 _tcSol = new Solution1987();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "binary = \"001\"");
        try {
            String binary = "001";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfUniqueGoodSubsequences(binary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "binary = \"11\"");
        try {
            String binary = "11";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfUniqueGoodSubsequences(binary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "binary = \"101\"");
        try {
            String binary = "101";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfUniqueGoodSubsequences(binary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}