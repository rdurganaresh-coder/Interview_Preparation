package com.leetcode.strings;

class Solution3340 {
    public boolean isBalanced(String num) {
        int[] f = new int[2];
        for (int i = 0; i < num.length(); ++i) {
            f[i & 1] += num.charAt(i) - '0';
        }
        return f[0] == f[1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3340 _tcSol = new Solution3340();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"1234\"");
        try {
            String num = "1234";
            System.out.println("  Output  : " + _tcShow(_tcSol.isBalanced(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"24123\"");
        try {
            String num = "24123";
            System.out.println("  Output  : " + _tcShow(_tcSol.isBalanced(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
