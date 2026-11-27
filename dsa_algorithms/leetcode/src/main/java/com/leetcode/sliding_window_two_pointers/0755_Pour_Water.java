package com.leetcode.sliding_window_two_pointers;

class Solution0755 {
    public int[] pourWater(int[] heights, int volume, int k) {
        while (volume-- > 0) {
            boolean find = false;
            for (int d = -1; d < 2 && !find; d += 2) {
                int i = k, j = k;
                while (i + d >= 0 && i + d < heights.length && heights[i + d] <= heights[i]) {
                    if (heights[i + d] < heights[i]) {
                        j = i + d;
                    }
                    i += d;
                }
                if (j != k) {
                    find = true;
                    ++heights[j];
                }
            }
            if (!find) {
                ++heights[k];
            }
        }
        return heights;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0755 _tcSol = new Solution0755();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [2,1,1,2,1,2,2], volume = 4, k = 3");
        try {
            int[] heights = new int[]{2, 1, 1, 2, 1, 2, 2};
            int volume = 4;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.pourWater(heights, volume, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,2,3,2,2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [1,2,3,4], volume = 2, k = 2");
        try {
            int[] heights = new int[]{1, 2, 3, 4};
            int volume = 2;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.pourWater(heights, volume, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,3,4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "heights = [3,1,3], volume = 5, k = 1");
        try {
            int[] heights = new int[]{3, 1, 3};
            int volume = 5;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.pourWater(heights, volume, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,4,4]");
        System.out.println();
    }
}