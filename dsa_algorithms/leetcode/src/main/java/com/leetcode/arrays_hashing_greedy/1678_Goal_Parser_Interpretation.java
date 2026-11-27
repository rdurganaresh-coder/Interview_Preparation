package com.leetcode.arrays_hashing_greedy;

class Solution1678 {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1678 _tcSol = new Solution1678();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "command = \"G()(al)\"");
        try {
            String command = "G()(al)";
            System.out.println("  Output  : " + _tcShow(_tcSol.interpret(command)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Goal\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "command = \"G()()()()(al)\"");
        try {
            String command = "G()()()()(al)";
            System.out.println("  Output  : " + _tcShow(_tcSol.interpret(command)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Gooooal\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "command = \"(al)G(al)()()G\"");
        try {
            String command = "(al)G(al)()()G";
            System.out.println("  Output  : " + _tcShow(_tcSol.interpret(command)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"alGalooG\"");
        System.out.println();
    }
}