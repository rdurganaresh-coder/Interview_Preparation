package com.leetcode.arrays_hashing_greedy;

class Solution2829 {
    public int minimumSum(int n, int k) {
        int s = 0, i = 1;
        boolean[] vis = new boolean[n + k + 1];
        while (n-- > 0) {
            while (vis[i]) {
                ++i;
            }
            if (k >= i) {
                vis[k - i] = true;
            }
            s += i++;
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2829 _tcSol = new Solution2829();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, k = 4");
        try {
            int n = 5;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSum(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, k = 6");
        try {
            int n = 2;
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSum(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
