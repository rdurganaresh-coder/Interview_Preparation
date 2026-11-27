package com.leetcode.arrays_hashing_greedy;

class Solution0605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for (int i = 0; i < m; ++i) {
            int l = i == 0 ? 0 : flowerbed[i - 1];
            int r = i == m - 1 ? 0 : flowerbed[i + 1];
            if (l + flowerbed[i] + r == 0) {
                flowerbed[i] = 1;
                --n;
            }
        }
        return n <= 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0605 _tcSol = new Solution0605();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "flowerbed = [1,0,0,0,1], n = 1");
        try {
            int[] flowerbed = new int[]{1, 0, 0, 0, 1};
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.canPlaceFlowers(flowerbed, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "flowerbed = [1,0,0,0,1], n = 2");
        try {
            int[] flowerbed = new int[]{1, 0, 0, 0, 1};
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.canPlaceFlowers(flowerbed, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}