package com.leetcode.sliding_window_two_pointers;

class Solution3455 {
    public int shortestMatchingSubstring(String s, String p) {
        int star = p.indexOf('*');
        int star2 = p.indexOf('*', star + 1);
        String a = p.substring(0, star);
        String b = p.substring(star + 1, star2);
        String c = p.substring(star2 + 1);
        int[] A = starts(s, a);
        int[] B = starts(s, b);
        int[] C = starts(s, c);
        int ans = s.length() + 1;
        int j = 0, k = 0;
        for (int i : A) {
            while (j < B.length && B[j] < i + a.length()) {
                ++j;
            }
            if (j == B.length) {
                break;
            }
            while (k < C.length && C[k] < B[j] + b.length()) {
                ++k;
            }
            if (k == C.length) {
                break;
            }
            ans = Math.min(ans, C[k] + c.length() - i);
        }
        return ans > s.length() ? -1 : ans;
    }

    private int[] starts(String s, String pat) {
        int n = s.length();
        if (pat.isEmpty()) {
            int[] res = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                res[i] = i;
            }
            return res;
        }
        int m = pat.length();
        int[] lps = new int[m];
        for (int i = 1, len = 0; i < m;) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                ++i;
            }
        }
        int[] tmp = new int[n];
        int cnt = 0;
        for (int i = 0, j = 0; i < n;) {
            if (s.charAt(i) == pat.charAt(j)) {
                ++i;
                ++j;
                if (j == m) {
                    tmp[cnt++] = i - m;
                    j = lps[j - 1];
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                ++i;
            }
        }
        int[] res = new int[cnt];
        System.arraycopy(tmp, 0, res, 0, cnt);
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3455 _tcSol = new Solution3455();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abaacbaecebce\", p = \"ba*c*ce\"");
        try {
            String s = "abaacbaecebce";
            String p = "ba*c*ce";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestMatchingSubstring(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"baccbaadbc\", p = \"cc*baa*adb\"");
        try {
            String s = "baccbaadbc";
            String p = "cc*baa*adb";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestMatchingSubstring(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"a\", p = \"**\"");
        try {
            String s = "a";
            String p = "**";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestMatchingSubstring(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "s = \"madlogic\", p = \"*adlogi*\"");
        try {
            String s = "madlogic";
            String p = "*adlogi*";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestMatchingSubstring(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
