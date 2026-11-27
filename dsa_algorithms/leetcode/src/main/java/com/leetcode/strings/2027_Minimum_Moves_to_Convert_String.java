package com.leetcode.strings;

class Solution2027 {
    public int minimumMoves(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'X') {
                ++ans;
                i += 2;
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
        Solution2027 _tcSol = new Solution2027();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"XXX\"");
        try {
            String s = "XXX";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumMoves(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"XXOX\"");
        try {
            String s = "XXOX";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumMoves(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"OOOO\"");
        try {
            String s = "OOOO";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumMoves(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}