package com.leetcode.arrays_hashing_greedy;

class Solution0006 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] g = new StringBuilder[numRows];
        Arrays.setAll(g, k -> new StringBuilder());
        int i = 0, k = -1;
        for (char c : s.toCharArray()) {
            g[i].append(c);
            if (i == 0 || i == numRows - 1) {
                k = -k;
            }
            i += k;
        }
        return String.join("", g);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0006 _tcSol = new Solution0006();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"PAYPALISHIRING\", numRows = 3");
        try {
            String s = "PAYPALISHIRING";
            int numRows = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.convert(s, numRows)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"PAHNAPLSIIGYIR\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"PAYPALISHIRING\", numRows = 4");
        try {
            String s = "PAYPALISHIRING";
            int numRows = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.convert(s, numRows)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"PINALSIGYAHRPI\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"A\", numRows = 1");
        try {
            String s = "A";
            int numRows = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.convert(s, numRows)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"A\"");
        System.out.println();
    }
}