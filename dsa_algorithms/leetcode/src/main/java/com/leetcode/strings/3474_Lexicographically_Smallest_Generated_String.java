package com.leetcode.strings;

class Solution3474 {
    public String generateString(String s, String t) {
        int n = s.length(), m = t.length();
        char[] ans = new char[n + m - 1];
        boolean[] fixed = new boolean[n + m - 1];

        Arrays.fill(ans, 'a');

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != 'T') {
                continue;
            }
            for (int j = 0; j < m; j++) {
                int k = i + j;
                if (fixed[k] && ans[k] != t.charAt(j)) {
                    return "";
                }
                ans[k] = t.charAt(j);
                fixed[k] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != 'F') {
                continue;
            }

            boolean same = true;
            for (int j = 0; j < m; j++) {
                if (ans[i + j] != t.charAt(j)) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                continue;
            }

            boolean ok = false;
            for (int j = i + m - 1; j >= i; j--) {
                if (!fixed[j]) {
                    ans[j] = 'b';
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                return "";
            }
        }

        return new String(ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3474 _tcSol = new Solution3474();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "str1 = \"TFTF\", str2 = \"ab\"");
        try {
            String s = "TFTF";
            String t = "ab";
            System.out.println("  Output  : " + _tcShow(_tcSol.generateString(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ababa\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "str1 = \"TFTF\", str2 = \"abc\"");
        try {
            String s = "TFTF";
            String t = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.generateString(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "str1 = \"F\", str2 = \"d\"");
        try {
            String s = "F";
            String t = "d";
            System.out.println("  Output  : " + _tcShow(_tcSol.generateString(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a\"");
        System.out.println();
    }
}
