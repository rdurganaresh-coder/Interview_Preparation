package com.leetcode.strings;

class Solution0844 {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skip1 = 0, skip2 = 0;
        for (; i >= 0 || j >= 0; --i, --j) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    ++skip1;
                    --i;
                } else if (skip1 > 0) {
                    --skip1;
                    --i;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    ++skip2;
                    --j;
                } else if (skip2 > 0) {
                    --skip2;
                    --j;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0844 _tcSol = new Solution0844();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ab#c\", t = \"ad#c\"");
        try {
            String s = "ab#c";
            String t = "ad#c";
            System.out.println("  Output  : " + _tcShow(_tcSol.backspaceCompare(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"ab##\", t = \"c#d#\"");
        try {
            String s = "ab##";
            String t = "c#d#";
            System.out.println("  Output  : " + _tcShow(_tcSol.backspaceCompare(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"a#c\", t = \"b\"");
        try {
            String s = "a#c";
            String t = "b";
            System.out.println("  Output  : " + _tcShow(_tcSol.backspaceCompare(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}