package com.leetcode.strings;

class Solution0434_2 {
    public int countSegments(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                ++ans;
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
        Solution0434_2 _tcSol = new Solution0434_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"Hello, my name is John\"");
        try {
            String s = "Hello, my name is John";
            System.out.println("  Output  : " + _tcShow(_tcSol.countSegments(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"Hello\"");
        try {
            String s = "Hello";
            System.out.println("  Output  : " + _tcShow(_tcSol.countSegments(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}