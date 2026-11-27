package com.leetcode.strings;

class Solution2573 {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        int i = 0;
        for (char c = 'a'; c <= 'z'; ++c) {
            while (i < n && s[i] != '\0') {
                ++i;
            }
            if (i == n) {
                break;
            }
            for (int j = i; j < n; ++j) {
                if (lcp[i][j] > 0) {
                    s[j] = c;
                }
            }
        }
        for (i = 0; i < n; ++i) {
            if (s[i] == '\0') {
                return "";
            }
        }
        for (i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (s[i] == s[j]) {
                    if (i == n - 1 || j == n - 1) {
                        if (lcp[i][j] != 1) {
                            return "";
                        }
                    } else if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
                        return "";
                    }
                } else if (lcp[i][j] > 0) {
                    return "";
                }
            }
        }
        return String.valueOf(s);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2573 _tcSol = new Solution2573();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "lcp = [[4,0,2,0],[0,3,0,1],[2,0,2,0],[0,1,0,1]]");
        try {
            int[][] lcp = new int[][]{new int[]{4, 0, 2, 0}, new int[]{0, 3, 0, 1}, new int[]{2, 0, 2, 0}, new int[]{0, 1, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheString(lcp)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abab\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "lcp = [[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,1]]");
        try {
            int[][] lcp = new int[][]{new int[]{4, 3, 2, 1}, new int[]{3, 3, 2, 1}, new int[]{2, 2, 2, 1}, new int[]{1, 1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheString(lcp)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaaa\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "lcp = [[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,3]]");
        try {
            int[][] lcp = new int[][]{new int[]{4, 3, 2, 1}, new int[]{3, 3, 2, 1}, new int[]{2, 2, 2, 1}, new int[]{1, 1, 1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheString(lcp)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}