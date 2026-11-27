package com.leetcode.bit_manipulation_math;

class Solution2523 {
    public int[] closestPrimes(int left, int right) {
        int cnt = 0;
        boolean[] st = new boolean[right + 1];
        int[] prime = new int[right + 1];
        for (int i = 2; i <= right; ++i) {
            if (!st[i]) {
                prime[cnt++] = i;
            }
            for (int j = 0; prime[j] <= right / i; ++j) {
                st[prime[j] * i] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
        int i = -1, j = -1;
        for (int k = 0; k < cnt; ++k) {
            if (prime[k] >= left && prime[k] <= right) {
                if (i == -1) {
                    i = k;
                }
                j = k;
            }
        }
        int[] ans = new int[] {-1, -1};
        if (i == j || i == -1) {
            return ans;
        }
        int mi = 1 << 30;
        for (int k = i; k < j; ++k) {
            int d = prime[k + 1] - prime[k];
            if (d < mi) {
                mi = d;
                ans[0] = prime[k];
                ans[1] = prime[k + 1];
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
        Solution2523 _tcSol = new Solution2523();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "left = 10, right = 19");
        try {
            int left = 10;
            int right = 19;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestPrimes(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[11,13]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "left = 4, right = 6");
        try {
            int left = 4;
            int right = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestPrimes(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1]");
        System.out.println();
    }
}