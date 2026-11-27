package com.leetcode.strings;

class Solution0418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int m = s.length();
        int cur = 0;
        while (rows-- > 0) {
            cur += cols;
            if (s.charAt(cur % m) == ' ') {
                ++cur;
            } else {
                while (cur > 0 && s.charAt((cur - 1) % m) != ' ') {
                    --cur;
                }
            }
        }
        return cur / m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0418 _tcSol = new Solution0418();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence = [\"hello\",\"world\"], rows = 2, cols = 8");
        try {
            String[] sentence = new String[]{"hello", "world"};
            int rows = 2;
            int cols = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.wordsTyping(sentence, rows, cols)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence = [\"a\", \"bcd\", \"e\"], rows = 3, cols = 6");
        try {
            String[] sentence = new String[]{"a", "bcd", "e"};
            int rows = 3;
            int cols = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.wordsTyping(sentence, rows, cols)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sentence = [\"i\",\"had\",\"apple\",\"pie\"], rows = 4, cols = 5");
        try {
            String[] sentence = new String[]{"i", "had", "apple", "pie"};
            int rows = 4;
            int cols = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.wordsTyping(sentence, rows, cols)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}