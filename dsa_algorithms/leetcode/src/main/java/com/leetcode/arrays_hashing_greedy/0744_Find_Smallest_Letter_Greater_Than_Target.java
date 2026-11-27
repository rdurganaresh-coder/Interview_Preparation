package com.leetcode.arrays_hashing_greedy;

class Solution0744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int i = Arrays.binarySearch(letters, (char) (target + 1));
        i = i < 0 ? -i - 1 : i;
        return letters[i % letters.length];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0744 _tcSol = new Solution0744();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "letters = [\"c\",\"f\",\"j\"], target = \"a\"");
        try {
            char[] letters = new char[]{'c', 'f', 'j'};
            char target = 'a';
            System.out.println("  Output  : " + _tcShow(_tcSol.nextGreatestLetter(letters, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"c\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "letters = [\"c\",\"f\",\"j\"], target = \"c\"");
        try {
            char[] letters = new char[]{'c', 'f', 'j'};
            char target = 'c';
            System.out.println("  Output  : " + _tcShow(_tcSol.nextGreatestLetter(letters, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"f\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "letters = [\"x\",\"x\",\"y\",\"y\"], target = \"z\"");
        try {
            char[] letters = new char[]{'x', 'x', 'y', 'y'};
            char target = 'z';
            System.out.println("  Output  : " + _tcShow(_tcSol.nextGreatestLetter(letters, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"x\"");
        System.out.println();
    }
}