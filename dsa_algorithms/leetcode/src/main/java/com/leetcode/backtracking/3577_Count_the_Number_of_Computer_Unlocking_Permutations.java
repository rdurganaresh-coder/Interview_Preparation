package com.leetcode.backtracking;

class Solution3577 {
    public int countPermutations(int[] complexity) {
        final int mod = (int) 1e9 + 7;
        long ans = 1;
        for (int i = 1; i < complexity.length; ++i) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
            ans = ans * i % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3577 _tcSol = new Solution3577();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "complexity = [1,2,3]");
        try {
            int[] complexity = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPermutations(complexity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "complexity = [3,3,3,4,4,4]");
        try {
            int[] complexity = new int[]{3, 3, 3, 4, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPermutations(complexity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}