package com.leetcode.arrays_hashing_greedy;

class Solution1482 {
    private int[] bloomDay;
    private int m, k;

    public int minDays(int[] bloomDay, int m, int k) {
        this.bloomDay = bloomDay;
        this.m = m;
        this.k = k;
        final int mx = (int) 1e9;
        int l = 1, r = mx + 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l > mx ? -1 : l;
    }

    private boolean check(int days) {
        int cnt = 0, cur = 0;
        for (int x : bloomDay) {
            cur = x <= days ? cur + 1 : 0;
            if (cur == k) {
                ++cnt;
                cur = 0;
            }
        }
        return cnt >= m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1482 _tcSol = new Solution1482();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "bloomDay = [1,10,3,10,2], m = 3, k = 1");
        try {
            int[] bloomDay = new int[]{1, 10, 3, 10, 2};
            int m = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minDays(bloomDay, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "bloomDay = [1,10,3,10,2], m = 3, k = 2");
        try {
            int[] bloomDay = new int[]{1, 10, 3, 10, 2};
            int m = 3;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minDays(bloomDay, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3");
        try {
            int[] bloomDay = new int[]{7, 7, 7, 7, 12, 7, 7};
            int m = 2;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minDays(bloomDay, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}
