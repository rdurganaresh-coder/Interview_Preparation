package com.leetcode.sliding_window_two_pointers;

class Solution1513 {
    public int numSub(String s) {
        final int mod = 1_000_000_007;
        int ans = 0, cur = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                cur = 0;
            } else {
                cur++;
                ans = (ans + cur) % mod;
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
        Solution1513 _tcSol = new Solution1513();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"0110111\"");
        try {
            String s = "0110111";
            System.out.println("  Output  : " + _tcShow(_tcSol.numSub(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"101\"");
        try {
            String s = "101";
            System.out.println("  Output  : " + _tcShow(_tcSol.numSub(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"111111\"");
        try {
            String s = "111111";
            System.out.println("  Output  : " + _tcShow(_tcSol.numSub(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();
    }
}
