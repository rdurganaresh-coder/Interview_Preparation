package com.leetcode.strings;

class Solution3029 {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        for (int i = k; i < n; i += k) {
            if (word.substring(i).equals(word.substring(0, n - i))) {
                return i / k;
            }
        }
        return (n + k - 1) / k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3029 _tcSol = new Solution3029();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"abacaba\", k = 3");
        try {
            String word = "abacaba";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTimeToInitialState(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"abacaba\", k = 4");
        try {
            String word = "abacaba";
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTimeToInitialState(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"abcbabcd\", k = 2");
        try {
            String word = "abcbabcd";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTimeToInitialState(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}