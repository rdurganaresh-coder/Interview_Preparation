package com.leetcode.backtracking;

class Solution0903_3 {
    public int numPermsDISequence(String s) {
        final int mod = (int) 1e9 + 7;
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            int pre = 0;
            int[] g = new int[n + 1];
            if (s.charAt(i - 1) == 'D') {
                for (int j = i; j >= 0; --j) {
                    pre = (pre + f[j]) % mod;
                    g[j] = pre;
                }
            } else {
                for (int j = 0; j <= i; ++j) {
                    g[j] = pre;
                    pre = (pre + f[j]) % mod;
                }
            }
            f = g;
        }
        int ans = 0;
        for (int j = 0; j <= n; ++j) {
            ans = (ans + f[j]) % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0903_3 _tcSol = new Solution0903_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"DID\"");
        try {
            String s = "DID";
            System.out.println("  Output  : " + _tcShow(_tcSol.numPermsDISequence(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"D\"");
        try {
            String s = "D";
            System.out.println("  Output  : " + _tcShow(_tcSol.numPermsDISequence(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}