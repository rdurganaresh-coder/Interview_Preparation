package com.leetcode.arrays_hashing_greedy;

class Solution1710_2 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] cnt = new int[1001];
        for (var e : boxTypes) {
            int a = e[0], b = e[1];
            cnt[b] += a;
        }
        int ans = 0;
        for (int b = 1000; b > 0 && truckSize > 0; --b) {
            int a = cnt[b];
            if (a > 0) {
                ans += b * Math.min(truckSize, a);
                truckSize -= a;
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
        Solution1710_2 _tcSol = new Solution1710_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4");
        try {
            int[][] boxTypes = new int[][]{new int[]{1, 3}, new int[]{2, 2}, new int[]{3, 1}};
            int truckSize = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumUnits(boxTypes, truckSize)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10");
        try {
            int[][] boxTypes = new int[][]{new int[]{5, 10}, new int[]{2, 5}, new int[]{4, 7}, new int[]{3, 9}};
            int truckSize = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumUnits(boxTypes, truckSize)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "91");
        System.out.println();
    }
}