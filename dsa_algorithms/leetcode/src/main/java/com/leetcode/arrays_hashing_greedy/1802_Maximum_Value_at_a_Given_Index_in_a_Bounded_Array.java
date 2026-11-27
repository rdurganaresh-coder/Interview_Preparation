package com.leetcode.arrays_hashing_greedy;

class Solution1802 {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (sum(mid - 1, index) + sum(mid, n - index) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long sum(long x, int cnt) {
        return x >= cnt ? (x + x - cnt + 1) * cnt / 2 : (x + 1) * x / 2 + cnt - x;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1802 _tcSol = new Solution1802();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, index = 2, maxSum = 6");
        try {
            int n = 4;
            int index = 2;
            int maxSum = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValue(n, index, maxSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, index = 1, maxSum = 10");
        try {
            int n = 6;
            int index = 1;
            int maxSum = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValue(n, index, maxSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}