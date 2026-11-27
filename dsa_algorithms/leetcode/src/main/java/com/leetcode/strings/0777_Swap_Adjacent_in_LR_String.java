package com.leetcode.strings;

class Solution0777 {
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (true) {
            while (i < n && start.charAt(i) == 'X') {
                ++i;
            }
            while (j < n && end.charAt(j) == 'X') {
                ++j;
            }
            if (i == n && j == n) {
                return true;
            }
            if (i == n || j == n || start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R' && i > j) {
                return false;
            }
            ++i;
            ++j;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0777 _tcSol = new Solution0777();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "start = \"RXXLRXRXL\", result = \"XRLXXRRLX\"");
        try {
            String start = "RXXLRXRXL";
            String end = "XRLXXRRLX";
            System.out.println("  Output  : " + _tcShow(_tcSol.canTransform(start, end)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "start = \"X\", result = \"L\"");
        try {
            String start = "X";
            String end = "L";
            System.out.println("  Output  : " + _tcShow(_tcSol.canTransform(start, end)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}