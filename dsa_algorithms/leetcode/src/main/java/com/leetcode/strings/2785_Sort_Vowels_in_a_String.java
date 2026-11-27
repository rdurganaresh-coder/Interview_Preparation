package com.leetcode.strings;

class Solution2785 {
    public String sortVowels(String s) {
        List<Character> vs = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            char d = Character.toLowerCase(c);
            if (d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u') {
                vs.add(c);
            }
        }
        Collections.sort(vs);
        for (int i = 0, j = 0; i < cs.length; ++i) {
            char d = Character.toLowerCase(cs[i]);
            if (d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u') {
                cs[i] = vs.get(j++);
            }
        }
        return String.valueOf(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2785 _tcSol = new Solution2785();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"lEetcOde\"");
        try {
            String s = "lEetcOde";
            System.out.println("  Output  : " + _tcShow(_tcSol.sortVowels(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"lEOtcede\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"lYmpH\"");
        try {
            String s = "lYmpH";
            System.out.println("  Output  : " + _tcShow(_tcSol.sortVowels(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"lYmpH\"");
        System.out.println();
    }
}