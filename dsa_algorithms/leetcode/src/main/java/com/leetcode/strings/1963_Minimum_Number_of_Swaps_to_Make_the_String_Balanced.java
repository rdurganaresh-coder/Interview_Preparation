package com.leetcode.strings;

class Solution1963 {
    public int minSwaps(String s) {
        int x = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '[') {
                ++x;
            } else if (x > 0) {
                --x;
            }
        }
        return (x + 1) / 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1963 _tcSol = new Solution1963();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"][][\"");
        try {
            String s = "][][";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"]]][[[\"");
        try {
            String s = "]]][[[";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"[]\"");
        try {
            String s = "[]";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}