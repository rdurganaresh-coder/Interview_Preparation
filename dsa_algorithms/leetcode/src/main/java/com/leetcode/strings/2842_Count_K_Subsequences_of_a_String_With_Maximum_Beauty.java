package com.leetcode.strings;

class Solution2842 {
    private final int mod = (int) 1e9 + 7;

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int[] f = new int[26];
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (++f[s.charAt(i) - 'a'] == 1) {
                ++cnt;
            }
        }
        if (cnt < k) {
            return 0;
        }
        Integer[] vs = new Integer[cnt];
        for (int i = 0, j = 0; i < 26; ++i) {
            if (f[i] > 0) {
                vs[j++] = f[i];
            }
        }
        Arrays.sort(vs, (a, b) -> b - a);
        long ans = 1;
        int val = vs[k - 1];
        int x = 0;
        for (int v : vs) {
            if (v == val) {
                ++x;
            }
        }
        for (int v : vs) {
            if (v == val) {
                break;
            }
            --k;
            ans = ans * v % mod;
        }
        int[][] c = new int[x + 1][x + 1];
        for (int i = 0; i <= x; ++i) {
            c[i][0] = 1;
            for (int j = 1; j <= i; ++j) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod;
            }
        }
        ans = ((ans * c[x][k]) % mod) * qpow(val, k) % mod;
        return (int) ans;
    }

    private long qpow(long a, int n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2842 _tcSol = new Solution2842();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"bcca\", k = 2");
        try {
            String s = "bcca";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countKSubsequencesWithMaxBeauty(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abbcd\", k = 4");
        try {
            String s = "abbcd";
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.countKSubsequencesWithMaxBeauty(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}