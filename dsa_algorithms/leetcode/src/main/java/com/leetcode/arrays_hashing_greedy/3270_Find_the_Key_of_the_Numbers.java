package com.leetcode.arrays_hashing_greedy;

class Solution3270 {
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0, k = 1;
        for (int i = 0; i < 4; ++i) {
            int x = Math.min(Math.min(num1 / k % 10, num2 / k % 10), num3 / k % 10);
            ans += x * k;
            k *= 10;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3270 _tcSol = new Solution3270();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num1 = 1, num2 = 10, num3 = 1000");
        try {
            int num1 = 1;
            int num2 = 10;
            int num3 = 1000;
            System.out.println("  Output  : " + _tcShow(_tcSol.generateKey(num1, num2, num3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num1 = 987, num2 = 879, num3 = 798");
        try {
            int num1 = 987;
            int num2 = 879;
            int num3 = 798;
            System.out.println("  Output  : " + _tcShow(_tcSol.generateKey(num1, num2, num3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "777");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num1 = 1, num2 = 2, num3 = 3");
        try {
            int num1 = 1;
            int num2 = 2;
            int num3 = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.generateKey(num1, num2, num3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
