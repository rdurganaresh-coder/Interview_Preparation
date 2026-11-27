package com.leetcode.arrays_hashing_greedy;

class Solution1891 {
    public int maxLength(int[] ribbons, int k) {
        int left = 0, right = 0;
        for (int x : ribbons) {
            right = Math.max(right, x);
        }
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            int cnt = 0;
            for (int x : ribbons) {
                cnt += x / mid;
            }
            if (cnt >= k) {
                left = mid;
            } else {
                right = mid - 1;
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
        Solution1891 _tcSol = new Solution1891();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ribbons = [9,7,5], k = 3");
        try {
            int[] ribbons = new int[]{9, 7, 5};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLength(ribbons, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ribbons = [7,5,9], k = 4");
        try {
            int[] ribbons = new int[]{7, 5, 9};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLength(ribbons, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "ribbons = [5,7,9], k = 22");
        try {
            int[] ribbons = new int[]{5, 7, 9};
            int k = 22;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLength(ribbons, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}