package com.leetcode.sliding_window_two_pointers;

class Solution0076 {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];
        for (char c : t.toCharArray()) {
            ++need[c];
        }
        int m = s.length(), n = t.length();
        int k = -1, mi = m + 1, cnt = 0;
        for (int l = 0, r = 0; r < m; ++r) {
            char c = s.charAt(r);
            if (++window[c] <= need[c]) {
                ++cnt;
            }
            while (cnt == n) {
                if (r - l + 1 < mi) {
                    mi = r - l + 1;
                    k = l;
                }
                c = s.charAt(l);
                if (window[c] <= need[c]) {
                    --cnt;
                }
                --window[c];
                ++l;
            }
        }
        return k < 0 ? "" : s.substring(k, k + mi);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0076 _tcSol = new Solution0076();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ADOBECODEBANC\", t = \"ABC\"");
        try {
            String s = "ADOBECODEBANC";
            String t = "ABC";
            System.out.println("  Output  : " + _tcShow(_tcSol.minWindow(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"BANC\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"a\", t = \"a\"");
        try {
            String s = "a";
            String t = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.minWindow(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"a\", t = \"aa\"");
        try {
            String s = "a";
            String t = "aa";
            System.out.println("  Output  : " + _tcShow(_tcSol.minWindow(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}
