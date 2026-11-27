package com.leetcode.bit_manipulation_math;

class Solution1611 {
    public int minimumOneBitOperations(int n) {
        int ans = 0;
        for (; n > 0; n >>= 1) {
            ans ^= n;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1611 _tcSol = new Solution1611();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOneBitOperations(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6");
        try {
            int n = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOneBitOperations(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}