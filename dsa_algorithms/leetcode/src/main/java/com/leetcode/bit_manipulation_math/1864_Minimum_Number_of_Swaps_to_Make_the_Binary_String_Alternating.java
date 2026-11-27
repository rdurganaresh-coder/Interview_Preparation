package com.leetcode.bit_manipulation_math;

class Solution1864 {
    private char[] s;

    public int minSwaps(String s) {
        this.s = s.toCharArray();
        int n1 = 0;
        for (char c : this.s) {
            n1 += (c - '0');
        }
        int n0 = this.s.length - n1;
        if (Math.abs(n0 - n1) > 1) {
            return -1;
        }
        if (n0 == n1) {
            return Math.min(calc(0), calc(1));
        }
        return calc(n0 > n1 ? 0 : 1);
    }

    private int calc(int c) {
        int cnt = 0;
        for (int i = 0; i < s.length; ++i) {
            int x = s[i] - '0';
            if ((i & 1 ^ c) != x) {
                ++cnt;
            }
        }
        return cnt / 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1864 _tcSol = new Solution1864();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"111000\"");
        try {
            String s = "111000";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"010\"");
        try {
            String s = "010";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1110\"");
        try {
            String s = "1110";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
