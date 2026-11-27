package com.leetcode.strings;

class Solution0767 {
    public String reorganizeString(String s) {
        int[] cnt = new int[26];
        int mx = 0;
        for (char c : s.toCharArray()) {
            int t = c - 'a';
            ++cnt[t];
            mx = Math.max(mx, cnt[t]);
        }
        int n = s.length();
        if (mx > (n + 1) / 2) {
            return "";
        }
        int k = 0;
        for (int v : cnt) {
            if (v > 0) {
                ++k;
            }
        }
        int[][] m = new int[k][2];
        k = 0;
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0) {
                m[k++] = new int[] {cnt[i], i};
            }
        }
        Arrays.sort(m, (a, b) -> b[0] - a[0]);
        k = 0;
        StringBuilder ans = new StringBuilder(s);
        for (int[] e : m) {
            int v = e[0], i = e[1];
            while (v-- > 0) {
                ans.setCharAt(k, (char) ('a' + i));
                k += 2;
                if (k >= n) {
                    k = 1;
                }
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0767 _tcSol = new Solution0767();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aab\"");
        try {
            String s = "aab";
            System.out.println("  Output  : " + _tcShow(_tcSol.reorganizeString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aba\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaab\"");
        try {
            String s = "aaab";
            System.out.println("  Output  : " + _tcShow(_tcSol.reorganizeString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}