package com.leetcode.strings;

class Solution3579 {
    public int minOperations(String word1, String word2) {
        int n = word1.length();
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int a = calc(word1, word2, j, i - 1, false);
                int b = 1 + calc(word1, word2, j, i - 1, true);
                int t = Math.min(a, b);
                f[i] = Math.min(f[i], f[j] + t);
            }
        }
        return f[n];
    }

    private int calc(String word1, String word2, int l, int r, boolean rev) {
        int[][] cnt = new int[26][26];
        int res = 0;
        for (int i = l; i <= r; i++) {
            int j = rev ? r - (i - l) : i;
            int a = word1.charAt(j) - 'a';
            int b = word2.charAt(i) - 'a';
            if (a != b) {
                if (cnt[b][a] > 0) {
                    cnt[b][a]--;
                } else {
                    cnt[a][b]++;
                    res++;
                }
            }
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3579 _tcSol = new Solution3579();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word1 = \"abcdf\", word2 = \"dacbe\"");
        try {
            String word1 = "abcdf";
            String word2 = "dacbe";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word1 = \"abceded\", word2 = \"baecfef\"");
        try {
            String word1 = "abceded";
            String word2 = "baecfef";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word1 = \"abcdef\", word2 = \"fedabc\"");
        try {
            String word1 = "abcdef";
            String word2 = "fedabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
