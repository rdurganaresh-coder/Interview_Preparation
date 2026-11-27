package com.leetcode.arrays_hashing_greedy;

class Solution0875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = (int) 1e9;
        while (l < r) {
            int mid = (l + r) >> 1;
            int s = 0;
            for (int x : piles) {
                s += (x + mid - 1) / mid;
            }
            if (s <= h) {
                r = mid;
            } else {
                l = mid + 1;
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
        Solution0875 _tcSol = new Solution0875();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "piles = [3,6,7,11], h = 8");
        try {
            int[] piles = new int[]{3, 6, 7, 11};
            int h = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.minEatingSpeed(piles, h)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "piles = [30,11,23,4,20], h = 5");
        try {
            int[] piles = new int[]{30, 11, 23, 4, 20};
            int h = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minEatingSpeed(piles, h)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "piles = [30,11,23,4,20], h = 6");
        try {
            int[] piles = new int[]{30, 11, 23, 4, 20};
            int h = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minEatingSpeed(piles, h)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();
    }
}