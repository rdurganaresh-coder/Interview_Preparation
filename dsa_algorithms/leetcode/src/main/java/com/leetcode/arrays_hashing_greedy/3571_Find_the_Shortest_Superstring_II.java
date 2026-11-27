package com.leetcode.arrays_hashing_greedy;

class Solution3571 {
    public String shortestSuperstring(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return shortestSuperstring(s2, s1);
        }
        if (s2.contains(s1)) {
            return s2;
        }
        for (int i = 0; i < m; i++) {
            if (s2.startsWith(s1.substring(i))) {
                return s1.substring(0, i) + s2;
            }
            if (s2.endsWith(s1.substring(0, m - i))) {
                return s2 + s1.substring(m - i);
            }
        }
        return s1 + s2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3571 _tcSol = new Solution3571();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"aba\", s2 = \"bab\"");
        try {
            String s1 = "aba";
            String s2 = "bab";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSuperstring(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abab\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"aa\", s2 = \"aaa\"");
        try {
            String s1 = "aa";
            String s2 = "aaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSuperstring(s1, s2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaa\"");
        System.out.println();
    }
}
