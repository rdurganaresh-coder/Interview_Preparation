package com.leetcode.strings;

class Solution1529 {
    public int minFlips(String target) {
        int ans = 0;
        for (int i = 0; i < target.length(); ++i) {
            int v = target.charAt(i) - '0';
            if (((ans & 1) ^ v) != 0) {
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
        Solution1529 _tcSol = new Solution1529();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = \"10111\"");
        try {
            String target = "10111";
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = \"101\"");
        try {
            String target = "101";
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "target = \"00000\"");
        try {
            String target = "00000";
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}