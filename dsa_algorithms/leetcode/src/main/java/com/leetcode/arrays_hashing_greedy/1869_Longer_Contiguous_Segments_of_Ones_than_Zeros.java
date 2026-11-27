package com.leetcode.arrays_hashing_greedy;

class Solution1869 {
    public boolean checkZeroOnes(String s) {
        return f(s, '1') > f(s, '0');
    }

    private int f(String s, char x) {
        int cnt = 0, mx = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == x) {
                mx = Math.max(mx, ++cnt);
            } else {
                cnt = 0;
            }
        }
        return mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1869 _tcSol = new Solution1869();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1101\"");
        try {
            String s = "1101";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkZeroOnes(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"111000\"");
        try {
            String s = "111000";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkZeroOnes(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"110100010\"");
        try {
            String s = "110100010";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkZeroOnes(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}