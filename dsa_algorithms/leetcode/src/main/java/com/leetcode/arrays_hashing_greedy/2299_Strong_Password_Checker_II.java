package com.leetcode.arrays_hashing_greedy;

class Solution2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        int mask = 0;
        for (int i = 0; i < password.length(); ++i) {
            char c = password.charAt(i);
            if (i > 0 && c == password.charAt(i - 1)) {
                return false;
            }
            if (Character.isLowerCase(c)) {
                mask |= 1;
            } else if (Character.isUpperCase(c)) {
                mask |= 2;
            } else if (Character.isDigit(c)) {
                mask |= 4;
            } else {
                mask |= 8;
            }
        }
        return mask == 15;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2299 _tcSol = new Solution2299();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "password = \"IloveLe3tcode!\"");
        try {
            String password = "IloveLe3tcode!";
            System.out.println("  Output  : " + _tcShow(_tcSol.strongPasswordCheckerII(password)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "password = \"Me+You--IsMyDream\"");
        try {
            String password = "Me+You--IsMyDream";
            System.out.println("  Output  : " + _tcShow(_tcSol.strongPasswordCheckerII(password)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "password = \"1aB!\"");
        try {
            String password = "1aB!";
            System.out.println("  Output  : " + _tcShow(_tcSol.strongPasswordCheckerII(password)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}