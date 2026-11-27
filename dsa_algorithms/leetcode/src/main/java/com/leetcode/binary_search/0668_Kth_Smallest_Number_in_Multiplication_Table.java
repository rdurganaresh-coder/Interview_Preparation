package com.leetcode.binary_search;

class Solution0668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int i = 1; i <= m; ++i) {
                cnt += Math.min(mid / i, n);
            }
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0668 _tcSol = new Solution0668();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 3, n = 3, k = 5");
        try {
            int m = 3;
            int n = 3;
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKthNumber(m, n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 2, n = 3, k = 6");
        try {
            int m = 2;
            int n = 3;
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKthNumber(m, n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}