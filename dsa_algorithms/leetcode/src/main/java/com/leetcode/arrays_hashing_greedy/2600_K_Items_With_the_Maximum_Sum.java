package com.leetcode.arrays_hashing_greedy;

class Solution2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) {
            return k;
        }
        if (numZeros >= k - numOnes) {
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2600 _tcSol = new Solution2600();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2");
        try {
            int numOnes = 3;
            int numZeros = 2;
            int numNegOnes = 0;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4");
        try {
            int numOnes = 3;
            int numZeros = 2;
            int numNegOnes = 0;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}