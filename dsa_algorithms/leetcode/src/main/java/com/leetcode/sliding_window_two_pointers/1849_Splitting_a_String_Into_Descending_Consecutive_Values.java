package com.leetcode.sliding_window_two_pointers;

class Solution1849 {
    private char[] s;

    public boolean splitString(String s) {
        this.s = s.toCharArray();
        return dfs(0, -1);
    }

    private boolean dfs(int i, long x) {
        if (i >= s.length) {
            return true;
        }
        long y = 0;
        int r = x < 0 ? s.length - 1 : s.length;
        for (int j = i; j < r; ++j) {
            y = y * 10 + s[j] - '0';
            if ((x < 0 || x - y == 1) && dfs(j + 1, y)) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1849 _tcSol = new Solution1849();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1234\"");
        try {
            String s = "1234";
            System.out.println("  Output  : " + _tcShow(_tcSol.splitString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"050043\"");
        try {
            String s = "050043";
            System.out.println("  Output  : " + _tcShow(_tcSol.splitString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"9080701\"");
        try {
            String s = "9080701";
            System.out.println("  Output  : " + _tcShow(_tcSol.splitString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
