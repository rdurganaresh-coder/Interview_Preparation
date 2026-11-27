package com.leetcode.arrays_hashing_greedy;

class Solution0466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int m = s1.length(), n = s2.length();
        int[][] d = new int[n][0];
        for (int i = 0; i < n; ++i) {
            int j = i;
            int cnt = 0;
            for (int k = 0; k < m; ++k) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    if (++j == n) {
                        j = 0;
                        ++cnt;
                    }
                }
            }
            d[i] = new int[] {cnt, j};
        }
        int ans = 0;
        for (int j = 0; n1 > 0; --n1) {
            ans += d[j][0];
            j = d[j][1];
        }
        return ans / n2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0466 _tcSol = new Solution0466();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"acb\", n1 = 4, s2 = \"ab\", n2 = 2");
        try {
            String s1 = "acb";
            int n1 = 4;
            String s2 = "ab";
            int n2 = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaxRepetitions(s1, n1, s2, n2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"acb\", n1 = 1, s2 = \"acb\", n2 = 1");
        try {
            String s1 = "acb";
            int n1 = 1;
            String s2 = "acb";
            int n2 = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaxRepetitions(s1, n1, s2, n2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}