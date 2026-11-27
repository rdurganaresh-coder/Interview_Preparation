package com.leetcode.strings;

class Solution1805 {
    public int numDifferentIntegers(String word) {
        Set<String> s = new HashSet<>();
        int n = word.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(word.charAt(i))) {
                while (i < n && word.charAt(i) == '0') {
                    ++i;
                }
                int j = i;
                while (j < n && Character.isDigit(word.charAt(j))) {
                    ++j;
                }
                s.add(word.substring(i, j));
                i = j;
            }
        }
        return s.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1805 _tcSol = new Solution1805();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"a123bc34d8ef34\"");
        try {
            String word = "a123bc34d8ef34";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDifferentIntegers(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"leet1234code234\"");
        try {
            String word = "leet1234code234";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDifferentIntegers(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"a1b01c001\"");
        try {
            String word = "a1b01c001";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDifferentIntegers(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}