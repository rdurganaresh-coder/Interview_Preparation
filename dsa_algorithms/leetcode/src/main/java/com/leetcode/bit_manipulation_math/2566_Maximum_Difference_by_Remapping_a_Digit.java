package com.leetcode.bit_manipulation_math;

class Solution2566 {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int mi = Integer.parseInt(s.replace(s.charAt(0), '0'));
        for (char c : s.toCharArray()) {
            if (c != '9') {
                return Integer.parseInt(s.replace(c, '9')) - mi;
            }
        }
        return num - mi;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2566 _tcSol = new Solution2566();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 11891");
        try {
            int num = 11891;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMaxDifference(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "99009");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 90");
        try {
            int num = 90;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMaxDifference(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "99");
        System.out.println();
    }
}