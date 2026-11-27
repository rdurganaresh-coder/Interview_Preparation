package com.leetcode.strings;

class Solution0058 {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            --i;
        }
        int j = i;
        while (j >= 0 && s.charAt(j) != ' ') {
            --j;
        }
        return i - j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0058 _tcSol = new Solution0058();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"Hello World\"");
        try {
            String s = "Hello World";
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLastWord(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \" fly me to the moon \"");
        try {
            String s = " fly me to the moon ";
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLastWord(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"luffy is still joyboy\"");
        try {
            String s = "luffy is still joyboy";
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLastWord(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}