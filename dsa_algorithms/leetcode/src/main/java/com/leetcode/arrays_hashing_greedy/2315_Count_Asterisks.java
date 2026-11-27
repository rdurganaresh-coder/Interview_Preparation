package com.leetcode.arrays_hashing_greedy;

class Solution2315 {
    public int countAsterisks(String s) {
        int ans = 0;
        for (int i = 0, ok = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '*') {
                ans += ok;
            } else if (c == '|') {
                ok ^= 1;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2315 _tcSol = new Solution2315();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"l|*e*et|c**o|*de|\"");
        try {
            String s = "l|*e*et|c**o|*de|";
            System.out.println("  Output  : " + _tcShow(_tcSol.countAsterisks(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"iamprogrammer\"");
        try {
            String s = "iamprogrammer";
            System.out.println("  Output  : " + _tcShow(_tcSol.countAsterisks(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"yo|uar|e**|b|e***au|tifu|l\"");
        try {
            String s = "yo|uar|e**|b|e***au|tifu|l";
            System.out.println("  Output  : " + _tcShow(_tcSol.countAsterisks(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}