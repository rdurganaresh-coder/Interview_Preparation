package com.leetcode.sliding_window_two_pointers;

class Solution1763 {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int k = -1;
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            Set<Character> ss = new HashSet<>();
            for (int j = i; j < n; ++j) {
                ss.add(s.charAt(j));
                boolean ok = true;
                for (char a : ss) {
                    char b = (char) (a ^ 32);
                    if (!(ss.contains(a) && ss.contains(b))) {
                        ok = false;
                        break;
                    }
                }
                if (ok && mx < j - i + 1) {
                    mx = j - i + 1;
                    k = i;
                }
            }
        }
        return k == -1 ? "" : s.substring(k, k + mx);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1763 _tcSol = new Solution1763();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"YazaAay\"");
        try {
            String s = "YazaAay";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestNiceSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aAa\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"Bb\"");
        try {
            String s = "Bb";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestNiceSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Bb\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"c\"");
        try {
            String s = "c";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestNiceSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}