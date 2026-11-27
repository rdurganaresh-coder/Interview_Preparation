package com.leetcode.arrays_hashing_greedy;

class Solution2266 {
    private static final int N = 100010;
    private static final int MOD = (int) 1e9 + 7;
    private static long[] f = new long[N];
    private static long[] g = new long[N];
    static {
        f[0] = f[1] = 1;
        f[2] = 2;
        f[3] = 4;
        g[0] = g[1] = 1;
        g[2] = 2;
        g[3] = 4;
        for (int i = 4; i < N; ++i) {
            f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % MOD;
            g[i] = (g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD;
        }
    }

    public int countTexts(String pressedKeys) {
        long ans = 1;
        for (int i = 0, n = pressedKeys.length(); i < n; ++i) {
            char c = pressedKeys.charAt(i);
            int j = i;
            while (j + 1 < n && pressedKeys.charAt(j + 1) == c) {
                ++j;
            }
            int cnt = j - i + 1;
            ans = c == '7' || c == '9' ? ans * g[cnt] : ans * f[cnt];
            ans %= MOD;
            i = j;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2266 _tcSol = new Solution2266();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pressedKeys = \"22233\"");
        try {
            String pressedKeys = "22233";
            System.out.println("  Output  : " + _tcShow(_tcSol.countTexts(pressedKeys)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pressedKeys = \"222222222222222222222222222222222222\"");
        try {
            String pressedKeys = "222222222222222222222222222222222222";
            System.out.println("  Output  : " + _tcShow(_tcSol.countTexts(pressedKeys)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "82876089");
        System.out.println();
    }
}
