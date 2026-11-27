package com.leetcode.arrays_hashing_greedy;

class Solution2582_2 {
    public int passThePillow(int n, int time) {
        int k = time / (n - 1);
        int mod = time % (n - 1);
        return (k & 1) == 1 ? n - mod : mod + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2582_2 _tcSol = new Solution2582_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, time = 5");
        try {
            int n = 4;
            int time = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.passThePillow(n, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, time = 2");
        try {
            int n = 3;
            int time = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.passThePillow(n, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}