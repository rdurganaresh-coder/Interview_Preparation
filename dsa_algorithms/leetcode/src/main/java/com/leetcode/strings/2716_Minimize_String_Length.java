package com.leetcode.strings;

class Solution2716 {
    public int minimizedStringLength(String s) {
        Set<Character> ss = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            ss.add(s.charAt(i));
        }
        return ss.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2716 _tcSol = new Solution2716();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aaabc\"");
        try {
            String s = "aaabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizedStringLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"cbbd\"");
        try {
            String s = "cbbd";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizedStringLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"baadccab\"");
        try {
            String s = "baadccab";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizedStringLength(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}