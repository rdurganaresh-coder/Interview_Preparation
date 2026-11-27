package com.leetcode.arrays_hashing_greedy;

class Solution2358 {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (1L * mid * mid + mid > n * 2L) {
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
        Solution2358 _tcSol = new Solution2358();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grades = [10,6,12,7,3,5]");
        try {
            int[] grades = new int[]{10, 6, 12, 7, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumGroups(grades)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grades = [8,8]");
        try {
            int[] grades = new int[]{8, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumGroups(grades)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}