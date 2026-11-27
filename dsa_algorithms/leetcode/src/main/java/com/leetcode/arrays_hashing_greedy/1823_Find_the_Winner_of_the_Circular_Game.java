package com.leetcode.arrays_hashing_greedy;

class Solution1823 {
    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        int ans = (findTheWinner(n - 1, k) + k) % n;
        return ans == 0 ? n : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1823 _tcSol = new Solution1823();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, k = 2");
        try {
            int n = 5;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheWinner(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, k = 5");
        try {
            int n = 6;
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheWinner(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}