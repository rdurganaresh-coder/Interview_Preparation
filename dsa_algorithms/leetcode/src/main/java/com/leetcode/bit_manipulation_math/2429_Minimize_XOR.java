package com.leetcode.bit_manipulation_math;

class Solution2429 {
    public int minimizeXor(int num1, int num2) {
        int cnt = Integer.bitCount(num2);
        int x = 0;
        for (int i = 30; i >= 0 && cnt > 0; --i) {
            if ((num1 >> i & 1) == 1) {
                x |= 1 << i;
                --cnt;
            }
        }
        for (int i = 0; cnt > 0; ++i) {
            if ((num1 >> i & 1) == 0) {
                x |= 1 << i;
                --cnt;
            }
        }
        return x;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2429 _tcSol = new Solution2429();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num1 = 3, num2 = 5");
        try {
            int num1 = 3;
            int num2 = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeXor(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num1 = 1, num2 = 12");
        try {
            int num1 = 1;
            int num2 = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeXor(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}