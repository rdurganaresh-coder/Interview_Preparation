package com.leetcode.bit_manipulation_math;

class Solution3032_2 {
    public int numberCount(int a, int b) {
        int res = 0;
        for (int i = a; i <= b; ++i) {
            if (isValid(i)) {
                ++res;
            }
        }
        return res;
    }
    private boolean isValid(int n) {
        boolean[] present = new boolean[10];
        Arrays.fill(present, false);
        while (n > 0) {
            int dig = n % 10;
            if (present[dig]) {
                return false;
            }
            present[dig] = true;
            n /= 10;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3032_2 _tcSol = new Solution3032_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 1, b = 20");
        try {
            int a = 1;
            int b = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberCount(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 9, b = 19");
        try {
            int a = 9;
            int b = 19;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberCount(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "a = 80, b = 120");
        try {
            int a = 80;
            int b = 120;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberCount(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "27");
        System.out.println();
    }
}
