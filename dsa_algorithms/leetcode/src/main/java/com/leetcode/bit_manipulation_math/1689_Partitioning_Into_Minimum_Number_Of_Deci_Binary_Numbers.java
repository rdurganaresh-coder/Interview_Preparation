package com.leetcode.bit_manipulation_math;

class Solution1689 {
    public int minPartitions(String n) {
        int ans = 0;
        for (int i = 0; i < n.length(); ++i) {
            ans = Math.max(ans, n.charAt(i) - '0');
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1689 _tcSol = new Solution1689();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = \"32\"");
        try {
            String n = "32";
            System.out.println("  Output  : " + _tcShow(_tcSol.minPartitions(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = \"82734\"");
        try {
            String n = "82734";
            System.out.println("  Output  : " + _tcShow(_tcSol.minPartitions(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = \"27346209830709182346\"");
        try {
            String n = "27346209830709182346";
            System.out.println("  Output  : " + _tcShow(_tcSol.minPartitions(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}