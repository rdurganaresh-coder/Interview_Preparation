package com.leetcode.sliding_window_two_pointers;

class Solution1668 {
    public int maxRepeating(String sequence, String word) {
        for (int k = sequence.length() / word.length(); k > 0; --k) {
            if (sequence.contains(word.repeat(k))) {
                return k;
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1668 _tcSol = new Solution1668();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sequence = \"ababc\", word = \"ab\"");
        try {
            String sequence = "ababc";
            String word = "ab";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRepeating(sequence, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sequence = \"ababc\", word = \"ba\"");
        try {
            String sequence = "ababc";
            String word = "ba";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRepeating(sequence, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sequence = \"ababc\", word = \"ac\"");
        try {
            String sequence = "ababc";
            String word = "ac";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRepeating(sequence, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}