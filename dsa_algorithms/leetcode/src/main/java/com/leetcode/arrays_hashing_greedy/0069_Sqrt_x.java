package com.leetcode.arrays_hashing_greedy;

class Solution0069 {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0069 _tcSol = new Solution0069();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 4");
        try {
            int x = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.mySqrt(x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 8");
        try {
            int x = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.mySqrt(x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}