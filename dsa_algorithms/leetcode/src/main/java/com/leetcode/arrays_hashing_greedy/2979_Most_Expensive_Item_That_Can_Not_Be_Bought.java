package com.leetcode.arrays_hashing_greedy;

class Solution2979 {
    public int mostExpensiveItem(int primeOne, int primeTwo) {
        return primeOne * primeTwo - primeOne - primeTwo;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2979 _tcSol = new Solution2979();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "primeOne = 2, primeTwo = 5");
        try {
            int primeOne = 2;
            int primeTwo = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.mostExpensiveItem(primeOne, primeTwo)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "primeOne = 5, primeTwo = 7");
        try {
            int primeOne = 5;
            int primeTwo = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.mostExpensiveItem(primeOne, primeTwo)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();
    }
}