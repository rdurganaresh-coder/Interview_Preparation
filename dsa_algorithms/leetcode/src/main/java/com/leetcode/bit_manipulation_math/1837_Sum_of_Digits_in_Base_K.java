package com.leetcode.bit_manipulation_math;

class Solution1837 {
    public int sumBase(int n, int k) {
        int ans = 0;
        while (n != 0) {
            ans += n % k;
            n /= k;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1837 _tcSol = new Solution1837();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 34, k = 6");
        try {
            int n = 34;
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumBase(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 10, k = 10");
        try {
            int n = 10;
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumBase(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}