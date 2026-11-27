package com.leetcode.strings;

class Solution3210 {
    public String getEncryptedString(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; ++i) {
            cs[i] = s.charAt((i + k) % n);
        }
        return new String(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3210 _tcSol = new Solution3210();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"dart\", k = 3");
        try {
            String s = "dart";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getEncryptedString(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"tdar\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaa\", k = 1");
        try {
            String s = "aaa";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.getEncryptedString(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaa\"");
        System.out.println();
    }
}