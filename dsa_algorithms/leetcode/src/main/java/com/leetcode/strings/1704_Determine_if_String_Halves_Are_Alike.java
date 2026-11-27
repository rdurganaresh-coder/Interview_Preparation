package com.leetcode.strings;

class Solution1704 {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int n = s.length() >> 1;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            cnt += vowels.contains(s.charAt(i)) ? 1 : 0;
            cnt -= vowels.contains(s.charAt(i + n)) ? 1 : 0;
        }
        return cnt == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1704 _tcSol = new Solution1704();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"book\"");
        try {
            String s = "book";
            System.out.println("  Output  : " + _tcShow(_tcSol.halvesAreAlike(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"textbook\"");
        try {
            String s = "textbook";
            System.out.println("  Output  : " + _tcShow(_tcSol.halvesAreAlike(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}