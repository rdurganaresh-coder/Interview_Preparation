package com.leetcode.dynamic_programming;

class Hashing3213 {
    private final long[] p;
    private final long[] h;
    private final long mod;

    public Hashing3213(String word, long base, int mod) {
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

class Solution3213 {
    public int minimumCost(String target, String[] words, int[] costs) {
        final int base = 13331;
        final int mod = 998244353;
        final int inf = Integer.MAX_VALUE / 2;

        int n = target.length();
        Hashing3213 hashing = new Hashing3213(target, base, mod);

        int[] f = new int[n + 1];
        Arrays.fill(f, inf);
        f[0] = 0;

        TreeSet<Integer> ss = new TreeSet<>();
        for (String w : words) {
            ss.add(w.length());
        }

        Map<Long, Integer> d = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            long x = 0;
            for (char c : words[i].toCharArray()) {
                x = (x * base + c) % mod;
            }
            d.merge(x, costs[i], Integer::min);
        }

        for (int i = 1; i <= n; i++) {
            for (int j : ss) {
                if (j > i) {
                    break;
                }
                long x = hashing.query(i - j + 1, i);
                f[i] = Math.min(f[i], f[i - j] + d.getOrDefault(x, inf));
            }
        }

        return f[n] >= inf ? -1 : f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3213 _tcSol = new Solution3213();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = \"abcdef\", words = [\"abdef\",\"abc\",\"d\",\"def\",\"ef\"], costs = [100,1,1,10,5]");
        try {
            String target = "abcdef";
            String[] words = new String[]{"abdef", "abc", "d", "def", "ef"};
            int[] costs = new int[]{100, 1, 1, 10, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(target, words, costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = \"aaaa\", words = [\"z\",\"zz\",\"zzz\"], costs = [1,10,100]");
        try {
            String target = "aaaa";
            String[] words = new String[]{"z", "zz", "zzz"};
            int[] costs = new int[]{1, 10, 100};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(target, words, costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}