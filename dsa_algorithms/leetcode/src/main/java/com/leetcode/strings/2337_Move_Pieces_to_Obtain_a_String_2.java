package com.leetcode.strings;

class Solution2337_2 {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (true) {
            while (i < n && start.charAt(i) == '_') {
                ++i;
            }
            while (j < n && target.charAt(j) == '_') {
                ++j;
            }
            if (i == n && j == n) {
                return true;
            }
            if (i == n || j == n || start.charAt(i) != target.charAt(j)) {
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
        Solution2337_2 _tcSol = new Solution2337_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "start = \"_L__R__R_\", target = \"L______RR\"");
        try {
            String start = "_L__R__R_";
            String target = "L______RR";
            System.out.println("  Output  : " + _tcShow(_tcSol.canChange(start, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "start = \"R_L_\", target = \"__LR\"");
        try {
            String start = "R_L_";
            String target = "__LR";
            System.out.println("  Output  : " + _tcShow(_tcSol.canChange(start, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "start = \"_R\", target = \"R_\"");
        try {
            String start = "_R";
            String target = "R_";
            System.out.println("  Output  : " + _tcShow(_tcSol.canChange(start, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}