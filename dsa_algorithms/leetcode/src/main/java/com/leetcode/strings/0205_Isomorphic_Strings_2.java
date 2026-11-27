package com.leetcode.strings;

class Solution0205_2 {
    public boolean isIsomorphic(String s, String t) {
        int[] d1 = new int[256];
        int[] d2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char a = s.charAt(i), b = t.charAt(i);
            if (d1[a] != d2[b]) {
                return false;
            }
            d1[a] = i + 1;
            d2[b] = i + 1;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0205_2 _tcSol = new Solution0205_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"egg\", t = \"add\"");
        try {
            String s = "egg";
            String t = "add";
            System.out.println("  Output  : " + _tcShow(_tcSol.isIsomorphic(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"f11\", t = \"b23\"");
        try {
            String s = "f11";
            String t = "b23";
            System.out.println("  Output  : " + _tcShow(_tcSol.isIsomorphic(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"paper\", t = \"title\"");
        try {
            String s = "paper";
            String t = "title";
            System.out.println("  Output  : " + _tcShow(_tcSol.isIsomorphic(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}