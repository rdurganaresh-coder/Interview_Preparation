package com.leetcode.strings;

class Solution2575 {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] ans = new int[n];
        long x = 0;
        for (int i = 0; i < n; ++i) {
            x = (x * 10 + word.charAt(i) - '0') % m;
            if (x == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2575 _tcSol = new Solution2575();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"998244353\", m = 3");
        try {
            String word = "998244353";
            int m = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisibilityArray(word, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,0,0,0,1,1,0,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"1010\", m = 10");
        try {
            String word = "1010";
            int m = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisibilityArray(word, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,0,1]");
        System.out.println();
    }
}