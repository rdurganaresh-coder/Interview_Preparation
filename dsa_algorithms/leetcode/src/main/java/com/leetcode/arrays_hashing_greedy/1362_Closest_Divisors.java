package com.leetcode.arrays_hashing_greedy;

class Solution1362 {
    public int[] closestDivisors(int num) {
        int[] a = f(num + 1);
        int[] b = f(num + 2);
        return Math.abs(a[0] - a[1]) < Math.abs(b[0] - b[1]) ? a : b;
    }

    private int[] f(int x) {
        for (int i = (int) Math.sqrt(x);; --i) {
            if (x % i == 0) {
                return new int[] {i, x / i};
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1362 _tcSol = new Solution1362();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 8");
        try {
            int num = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestDivisors(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 123");
        try {
            int num = 123;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestDivisors(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,25]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = 999");
        try {
            int num = 999;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestDivisors(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[40,25]");
        System.out.println();
    }
}