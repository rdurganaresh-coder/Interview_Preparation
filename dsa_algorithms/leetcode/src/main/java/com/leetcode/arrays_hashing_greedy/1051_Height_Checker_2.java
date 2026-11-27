package com.leetcode.arrays_hashing_greedy;

class Solution1051_2 {
    public int heightChecker(int[] heights) {
        int[] cnt = new int[101];
        for (int h : heights) {
            ++cnt[h];
        }
        int ans = 0;
        for (int i = 0, j = 0; i < 101; ++i) {
            while (cnt[i] > 0) {
                --cnt[i];
                if (heights[j++] != i) {
                    ++ans;
                }
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
        Solution1051_2 _tcSol = new Solution1051_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [1,1,4,2,1,3]");
        try {
            int[] heights = new int[]{1, 1, 4, 2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.heightChecker(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [5,1,2,3,4]");
        try {
            int[] heights = new int[]{5, 1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.heightChecker(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "heights = [1,2,3,4,5]");
        try {
            int[] heights = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.heightChecker(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}