package com.leetcode.arrays_hashing_greedy;

class Solution1652_2 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        int[] s = new int[n << 1 | 1];
        for (int i = 0; i < n << 1; ++i) {
            s[i + 1] = s[i] + code[i % n];
        }
        for (int i = 0; i < n; ++i) {
            if (k > 0) {
                ans[i] = s[i + k + 1] - s[i + 1];
            } else {
                ans[i] = s[i + n] - s[i + k + n];
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
        Solution1652_2 _tcSol = new Solution1652_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "code = [5,7,1,4], k = 3");
        try {
            int[] code = new int[]{5, 7, 1, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.decrypt(code, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[12,10,16,13]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "code = [1,2,3,4], k = 0");
        try {
            int[] code = new int[]{1, 2, 3, 4};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.decrypt(code, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,0,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "code = [2,4,9,3], k = -2");
        try {
            int[] code = new int[]{2, 4, 9, 3};
            int k = -2;
            System.out.println("  Output  : " + _tcShow(_tcSol.decrypt(code, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[12,5,6,13]");
        System.out.println();
    }
}