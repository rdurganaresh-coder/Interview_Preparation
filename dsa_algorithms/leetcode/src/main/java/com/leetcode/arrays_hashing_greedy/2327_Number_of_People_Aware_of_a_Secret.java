package com.leetcode.arrays_hashing_greedy;

class Solution2327 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int mod = (int) 1e9 + 7;
        int m = (n << 1) + 10;
        long[] d = new long[m];
        long[] cnt = new long[m];
        cnt[1] = 1;
        for (int i = 1; i <= n; ++i) {
            if (cnt[i] > 0) {
                d[i] = (d[i] + cnt[i]) % mod;
                d[i + forget] = (d[i + forget] - cnt[i] + mod) % mod;
                int nxt = i + delay;
                while (nxt < i + forget) {
                    cnt[nxt] = (cnt[nxt] + cnt[i]) % mod;
                    ++nxt;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            ans = (ans + d[i]) % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2327 _tcSol = new Solution2327();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, delay = 2, forget = 4");
        try {
            int n = 6;
            int delay = 2;
            int forget = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.peopleAwareOfSecret(n, delay, forget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, delay = 1, forget = 3");
        try {
            int n = 4;
            int delay = 1;
            int forget = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.peopleAwareOfSecret(n, delay, forget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
