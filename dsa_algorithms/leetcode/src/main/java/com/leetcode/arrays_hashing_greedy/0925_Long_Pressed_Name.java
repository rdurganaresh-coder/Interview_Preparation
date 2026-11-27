package com.leetcode.arrays_hashing_greedy;

class Solution0925 {
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length(), n = typed.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (name.charAt(i) != typed.charAt(j)) {
                return false;
            }
            int x = i + 1;
            while (x < m && name.charAt(x) == name.charAt(i)) {
                ++x;
            }
            int y = j + 1;
            while (y < n && typed.charAt(y) == typed.charAt(j)) {
                ++y;
            }
            if (x - i > y - j) {
                return false;
            }
            i = x;
            j = y;
        }
        return i == m && j == n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0925 _tcSol = new Solution0925();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "name = \"alex\", typed = \"aaleex\"");
        try {
            String name = "alex";
            String typed = "aaleex";
            System.out.println("  Output  : " + _tcShow(_tcSol.isLongPressedName(name, typed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "name = \"saeed\", typed = \"ssaaedd\"");
        try {
            String name = "saeed";
            String typed = "ssaaedd";
            System.out.println("  Output  : " + _tcShow(_tcSol.isLongPressedName(name, typed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}