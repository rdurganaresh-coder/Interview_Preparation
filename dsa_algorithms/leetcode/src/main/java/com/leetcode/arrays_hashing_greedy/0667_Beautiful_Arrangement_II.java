package com.leetcode.arrays_hashing_greedy;

class Solution0667 {
    public int[] constructArray(int n, int k) {
        int l = 1, r = n;
        int[] ans = new int[n];
        for (int i = 0; i < k; ++i) {
            ans[i] = i % 2 == 0 ? l++ : r--;
        }
        for (int i = k; i < n; ++i) {
            ans[i] = k % 2 == 0 ? r-- : l++;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0667 _tcSol = new Solution0667();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 1");
        try {
            int n = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.constructArray(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, k = 2");
        try {
            int n = 3;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.constructArray(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,2]");
        System.out.println();
    }
}