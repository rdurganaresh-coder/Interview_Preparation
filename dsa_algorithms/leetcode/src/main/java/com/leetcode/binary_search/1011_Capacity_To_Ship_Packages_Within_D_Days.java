package com.leetcode.binary_search;

class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(mid, weights, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int mx, int[] weights, int days) {
        int ws = 0, cnt = 1;
        for (int w : weights) {
            ws += w;
            if (ws > mx) {
                ws = w;
                ++cnt;
            }
        }
        return cnt <= days;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1011 _tcSol = new Solution1011();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "weights = [1,2,3,4,5,6,7,8,9,10], days = 5");
        try {
            int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int days = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.shipWithinDays(weights, days)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "weights = [3,2,2,4,1,4], days = 3");
        try {
            int[] weights = new int[]{3, 2, 2, 4, 1, 4};
            int days = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.shipWithinDays(weights, days)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "weights = [1,2,3,1,1], days = 4");
        try {
            int[] weights = new int[]{1, 2, 3, 1, 1};
            int days = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.shipWithinDays(weights, days)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}