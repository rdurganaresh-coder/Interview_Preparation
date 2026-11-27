package com.leetcode.strings;

class Solution1427 {
    public String stringShift(String s, int[][] shift) {
        int x = 0;
        for (var e : shift) {
            if (e[0] == 0) {
                e[1] *= -1;
            }
            x += e[1];
        }
        int n = s.length();
        x = (x % n + n) % n;
        return s.substring(n - x) + s.substring(0, n - x);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1427 _tcSol = new Solution1427();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abc\", shift = [[0,1],[1,2]]");
        try {
            String s = "abc";
            int[][] shift = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.stringShift(s, shift)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"cab\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcdefg\", shift = [[1,1],[1,1],[0,2],[1,3]]");
        try {
            String s = "abcdefg";
            int[][] shift = new int[][]{new int[]{1, 1}, new int[]{1, 1}, new int[]{0, 2}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.stringShift(s, shift)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"efgabcd\"");
        System.out.println();
    }
}