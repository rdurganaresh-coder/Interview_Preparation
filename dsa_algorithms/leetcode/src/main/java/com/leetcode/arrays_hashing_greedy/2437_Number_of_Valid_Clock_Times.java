package com.leetcode.arrays_hashing_greedy;

class Solution2437 {
    public int countTime(String time) {
        int ans = 0;
        for (int h = 0; h < 24; ++h) {
            for (int m = 0; m < 60; ++m) {
                String s = String.format("%02d:%02d", h, m);
                int ok = 1;
                for (int i = 0; i < 5; ++i) {
                    if (s.charAt(i) != time.charAt(i) && time.charAt(i) != '?') {
                        ok = 0;
                        break;
                    }
                }
                ans += ok;
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
        Solution2437 _tcSol = new Solution2437();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "time = \"?5:00\"");
        try {
            String time = "?5:00";
            System.out.println("  Output  : " + _tcShow(_tcSol.countTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "time = \"0?:0?\"");
        try {
            String time = "0?:0?";
            System.out.println("  Output  : " + _tcShow(_tcSol.countTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "100");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "time = \"??:??\"");
        try {
            String time = "??:??";
            System.out.println("  Output  : " + _tcShow(_tcSol.countTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1440");
        System.out.println();
    }
}