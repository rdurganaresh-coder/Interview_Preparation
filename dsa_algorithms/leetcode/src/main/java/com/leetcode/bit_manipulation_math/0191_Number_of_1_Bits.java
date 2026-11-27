package com.leetcode.bit_manipulation_math;

class Solution0191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= n - 1;
            ++ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0191 _tcSol = new Solution0191();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 11");
        try {
            int n = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.hammingWeight(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 128");
        try {
            int n = 128;
            System.out.println("  Output  : " + _tcShow(_tcSol.hammingWeight(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2147483645");
        try {
            int n = 2147483645;
            System.out.println("  Output  : " + _tcShow(_tcSol.hammingWeight(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();
    }
}