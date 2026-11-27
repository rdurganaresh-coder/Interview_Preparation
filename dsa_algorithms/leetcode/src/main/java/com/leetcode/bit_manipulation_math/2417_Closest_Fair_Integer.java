package com.leetcode.bit_manipulation_math;

class Solution2417 {
    public int closestFair(int n) {
        int a = 0, b = 0;
        int k = 0, t = n;
        while (t > 0) {
            if ((t % 10) % 2 == 1) {
                ++a;
            } else {
                ++b;
            }
            t /= 10;
            ++k;
        }
        if (k % 2 == 1) {
            int x = (int) Math.pow(10, k);
            int y = 0;
            for (int i = 0; i < k >> 1; ++i) {
                y = y * 10 + 1;
            }
            return x + y;
        }
        if (a == b) {
            return n;
        }
        return closestFair(n + 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2417 _tcSol = new Solution2417();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestFair(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 403");
        try {
            int n = 403;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestFair(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1001");
        System.out.println();
    }
}