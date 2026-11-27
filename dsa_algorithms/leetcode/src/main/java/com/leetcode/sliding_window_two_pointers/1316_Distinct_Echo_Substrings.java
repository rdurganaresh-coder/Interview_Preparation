package com.leetcode.sliding_window_two_pointers;

class Solution1316 {
    private long[] h;
    private long[] p;

    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        int base = 131;
        h = new long[n + 10];
        p = new long[n + 10];
        p[0] = 1;
        for (int i = 0; i < n; ++i) {
            int t = text.charAt(i) - 'a' + 1;
            h[i + 1] = h[i] * base + t;
            p[i + 1] = p[i] * base;
        }
        Set<Long> vis = new HashSet<>();
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; j += 2) {
                int k = (i + j) >> 1;
                long a = get(i + 1, k + 1);
                long b = get(k + 2, j + 1);
                if (a == b) {
                    vis.add(a);
                }
            }
        }
        return vis.size();
    }

    private long get(int i, int j) {
        return h[j] - h[i - 1] * p[j - i + 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1316 _tcSol = new Solution1316();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \"abcabcabc\"");
        try {
            String text = "abcabcabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctEchoSubstrings(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \"leetcodeleetcode\"");
        try {
            String text = "leetcodeleetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctEchoSubstrings(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}