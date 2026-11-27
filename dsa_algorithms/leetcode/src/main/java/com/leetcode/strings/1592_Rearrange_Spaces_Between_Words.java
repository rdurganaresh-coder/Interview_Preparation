package com.leetcode.strings;

class Solution1592 {
    public String reorderSpaces(String text) {
        int spaces = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                ++spaces;
            }
        }
        String[] words = text.trim().split("\\s+");
        if (words.length == 1) {
            return words[0] + " ".repeat(spaces);
        }
        int cnt = spaces / (words.length - 1);
        int mod = spaces % (words.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append(" ".repeat(cnt));
            }
        }
        sb.append(" ".repeat(mod));
        return sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1592 _tcSol = new Solution1592();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \" this is a sentence \"");
        try {
            String text = " this is a sentence ";
            System.out.println("  Output  : " + _tcShow(_tcSol.reorderSpaces(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"this is a sentence\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \" practice makes perfect\"");
        try {
            String text = " practice makes perfect";
            System.out.println("  Output  : " + _tcShow(_tcSol.reorderSpaces(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"practice makes perfect \"");
        System.out.println();
    }
}
