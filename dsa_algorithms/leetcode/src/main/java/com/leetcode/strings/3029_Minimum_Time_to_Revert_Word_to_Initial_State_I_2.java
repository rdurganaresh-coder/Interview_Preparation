package com.leetcode.strings;

class Hashing3029_2 {
    private final long[] p;
    private final long[] h;
    private final long mod;

    public Hashing3029_2(String word, long base, int mod) {
        int n = word.length();
        p = new long[n + 1];
        h = new long[n + 1];
        p[0] = 1;
        this.mod = mod;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * base % mod;
            h[i] = (h[i - 1] * base + word.charAt(i - 1) - 'a') % mod;
        }
    }

    public long query(int l, int r) {
        return (h[r] - h[l - 1] * p[r - l + 1] % mod + mod) % mod;
    }
}

class Solution3029_2 {
    public int minimumTimeToInitialState(String word, int k) {
        Hashing3029_2 hashing = new Hashing3029_2(word, 13331, 998244353);
        int n = word.length();
        for (int i = k; i < n; i += k) {
            if (hashing.query(1, n - i) == hashing.query(i + 1, n)) {
                return i / k;
            }
        }
        return (n + k - 1) / k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3029_2 _tcSol = new Solution3029_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"abacaba\", k = 3");
        try {
            String word = "abacaba";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTimeToInitialState(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"abacaba\", k = 4");
        try {
            String word = "abacaba";
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTimeToInitialState(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"abcbabcd\", k = 2");
        try {
            String word = "abcbabcd";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTimeToInitialState(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}