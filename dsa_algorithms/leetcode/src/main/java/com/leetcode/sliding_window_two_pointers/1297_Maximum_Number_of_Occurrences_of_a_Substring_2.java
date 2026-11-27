package com.leetcode.sliding_window_two_pointers;

class Hashing1297_2 {
    private final long[] p;
    private final long[] h;
    private final long mod;

    public Hashing1297_2(String word) {
        this(word, 13331, 998244353);
    }

    public Hashing1297_2(String word, long base, int mod) {
        int n = word.length();
        p = new long[n + 1];
        h = new long[n + 1];
        p[0] = 1;
        this.mod = mod;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * base % mod;
            h[i] = (h[i - 1] * base + word.charAt(i - 1)) % mod;
        }
    }

    public long query(int l, int r) {
        return (h[r] - h[l - 1] * p[r - l + 1] % mod + mod) % mod;
    }
}

class Solution1297_2 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        Hashing1297_2 hashing = new Hashing1297_2(s);
        int[] freq = new int[256];
        int k = 0;
        int ans = 0;
        Map<Long, Integer> cnt = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            if (++freq[s.charAt(i - 1)] == 1) {
                k++;
            }

            if (i >= minSize) {
                if (k <= maxLetters) {
                    long x = hashing.query(i - minSize + 1, i);
                    ans = Math.max(ans, cnt.merge(x, 1, Integer::sum));
                }
                int j = i - minSize;
                if (--freq[s.charAt(j)] == 0) {
                    k--;
                }
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
        Solution1297_2 _tcSol = new Solution1297_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aababcaab\", maxLetters = 2, minSize = 3, maxSize = 4");
        try {
            String s = "aababcaab";
            int maxLetters = 2;
            int minSize = 3;
            int maxSize = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreq(s, maxLetters, minSize, maxSize)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaaa\", maxLetters = 1, minSize = 3, maxSize = 3");
        try {
            String s = "aaaa";
            int maxLetters = 1;
            int minSize = 3;
            int maxSize = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreq(s, maxLetters, minSize, maxSize)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
