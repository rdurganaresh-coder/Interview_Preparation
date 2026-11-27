package com.leetcode.strings;

class Solution0290 {
    public boolean wordPattern(String pattern, String s) {
        String[] ws = s.split(" ");
        if (pattern.length() != ws.length) {
            return false;
        }
        Map<Character, String> d1 = new HashMap<>();
        Map<String, Character> d2 = new HashMap<>();
        for (int i = 0; i < ws.length; ++i) {
            char a = pattern.charAt(i);
            String b = ws[i];
            if (!d1.getOrDefault(a, b).equals(b) || d2.getOrDefault(b, a) != a) {
                return false;
            }
            d1.put(a, b);
            d2.put(b, a);
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0290 _tcSol = new Solution0290();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pattern = \"abba\", s = \"dog cat cat dog\"");
        try {
            String pattern = "abba";
            String s = "dog cat cat dog";
            System.out.println("  Output  : " + _tcShow(_tcSol.wordPattern(pattern, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pattern = \"abba\", s = \"dog cat cat fish\"");
        try {
            String pattern = "abba";
            String s = "dog cat cat fish";
            System.out.println("  Output  : " + _tcShow(_tcSol.wordPattern(pattern, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "pattern = \"aaaa\", s = \"dog cat cat dog\"");
        try {
            String pattern = "aaaa";
            String s = "dog cat cat dog";
            System.out.println("  Output  : " + _tcShow(_tcSol.wordPattern(pattern, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}