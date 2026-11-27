package com.leetcode.arrays_hashing_greedy;

class Solution0171 {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); ++i) {
            ans = ans * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0171 _tcSol = new Solution0171();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "columnTitle = \"A\"");
        try {
            String columnTitle = "A";
            System.out.println("  Output  : " + _tcShow(_tcSol.titleToNumber(columnTitle)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "columnTitle = \"AB\"");
        try {
            String columnTitle = "AB";
            System.out.println("  Output  : " + _tcShow(_tcSol.titleToNumber(columnTitle)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "columnTitle = \"ZY\"");
        try {
            String columnTitle = "ZY";
            System.out.println("  Output  : " + _tcShow(_tcSol.titleToNumber(columnTitle)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "701");
        System.out.println();
    }
}