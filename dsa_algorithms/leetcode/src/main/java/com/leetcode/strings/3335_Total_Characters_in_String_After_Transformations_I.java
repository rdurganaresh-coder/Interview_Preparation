package com.leetcode.strings;

class Solution3335 {
    public int lengthAfterTransformations(String s, int t) {
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[t + 1][26];
        for (char c : s.toCharArray()) {
            f[0][c - 'a']++;
        }
        for (int i = 1; i <= t; ++i) {
            f[i][0] = f[i - 1][25] % mod;
            f[i][1] = (f[i - 1][0] + f[i - 1][25]) % mod;
            for (int j = 2; j < 26; j++) {
                f[i][j] = f[i - 1][j - 1] % mod;
            }
        }

        int ans = 0;
        for (int j = 0; j < 26; ++j) {
            ans = (ans + f[t][j]) % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3335 _tcSol = new Solution3335();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcyy\", t = 2");
        try {
            String s = "abcyy";
            int t = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthAfterTransformations(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"azbk\", t = 1");
        try {
            String s = "azbk";
            int t = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthAfterTransformations(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
