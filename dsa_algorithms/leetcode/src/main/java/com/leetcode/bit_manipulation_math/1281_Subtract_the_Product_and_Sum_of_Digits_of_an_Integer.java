package com.leetcode.bit_manipulation_math;

class Solution1281 {
    public int subtractProductAndSum(int n) {
        int x = 1, y = 0;
        for (; n > 0; n /= 10) {
            int v = n % 10;
            x *= v;
            y += v;
        }
        return x - y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1281 _tcSol = new Solution1281();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 234");
        try {
            int n = 234;
            System.out.println("  Output  : " + _tcShow(_tcSol.subtractProductAndSum(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4421");
        try {
            int n = 4421;
            System.out.println("  Output  : " + _tcShow(_tcSol.subtractProductAndSum(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();
    }
}