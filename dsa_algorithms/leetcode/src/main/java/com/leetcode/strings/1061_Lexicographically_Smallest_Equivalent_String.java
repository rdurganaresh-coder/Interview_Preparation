package com.leetcode.strings;

class Solution1061 {
    private final int[] p = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < p.length; ++i) {
            p[i] = i;
        }
        for (int i = 0; i < s1.length(); ++i) {
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            int px = find(x), py = find(y);
            if (px < py) {
                p[py] = px;
            } else {
                p[px] = py;
            }
        }
        char[] s = baseStr.toCharArray();
        for (int i = 0; i < s.length; ++i) {
            s[i] = (char) ('a' + find(s[i] - 'a'));
        }
        return String.valueOf(s);
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1061 _tcSol = new Solution1061();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"parker\", s2 = \"morris\", baseStr = \"parser\"");
        try {
            String s1 = "parker";
            String s2 = "morris";
            String baseStr = "parser";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestEquivalentString(s1, s2, baseStr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"makkek\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"hello\", s2 = \"world\", baseStr = \"hold\"");
        try {
            String s1 = "hello";
            String s2 = "world";
            String baseStr = "hold";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestEquivalentString(s1, s2, baseStr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"hdld\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s1 = \"leetcode\", s2 = \"programs\", baseStr = \"sourcecode\"");
        try {
            String s1 = "leetcode";
            String s2 = "programs";
            String baseStr = "sourcecode";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestEquivalentString(s1, s2, baseStr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aauaaaaada\"");
        System.out.println();
    }
}