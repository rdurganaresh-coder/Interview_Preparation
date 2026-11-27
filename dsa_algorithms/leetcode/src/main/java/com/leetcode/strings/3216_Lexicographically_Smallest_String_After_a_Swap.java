package com.leetcode.strings;

class Solution3216 {
    public String getSmallestString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 1; i < n; ++i) {
            char a = cs[i - 1], b = cs[i];
            if (a > b && a % 2 == b % 2) {
                cs[i] = a;
                cs[i - 1] = b;
                return new String(cs);
            }
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3216 _tcSol = new Solution3216();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"45320\"");
        try {
            String s = "45320";
            System.out.println("  Output  : " + _tcShow(_tcSol.getSmallestString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"43520\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"001\"");
        try {
            String s = "001";
            System.out.println("  Output  : " + _tcShow(_tcSol.getSmallestString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"001\"");
        System.out.println();
    }
}