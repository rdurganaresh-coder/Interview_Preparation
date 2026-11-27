package com.leetcode.arrays_hashing_greedy;

class Solution1881 {
    public String maxValue(String n, int x) {
        int i = 0;
        if (n.charAt(0) == '-') {
            ++i;
            while (i < n.length() && n.charAt(i) - '0' <= x) {
                ++i;
            }
        } else {
            while (i < n.length() && n.charAt(i) - '0' >= x) {
                ++i;
            }
        }
        return n.substring(0, i) + x + n.substring(i);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1881 _tcSol = new Solution1881();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = \"99\", x = 9");
        try {
            String n = "99";
            int x = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValue(n, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"999\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = \"-13\", x = 2");
        try {
            String n = "-13";
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValue(n, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"-123\"");
        System.out.println();
    }
}
