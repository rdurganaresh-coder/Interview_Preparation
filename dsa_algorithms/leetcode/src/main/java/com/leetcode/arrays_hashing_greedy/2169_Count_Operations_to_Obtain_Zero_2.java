package com.leetcode.arrays_hashing_greedy;

class Solution2169_2 {
    public int countOperations(int num1, int num2) {
        int ans = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                ans += num1 / num2;
                num1 %= num2;
            } else {
                ans += num2 / num1;
                num2 %= num1;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2169_2 _tcSol = new Solution2169_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num1 = 2, num2 = 3");
        try {
            int num1 = 2;
            int num2 = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOperations(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num1 = 10, num2 = 10");
        try {
            int num1 = 10;
            int num2 = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOperations(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
