package com.leetcode.arrays_hashing_greedy;

class Solution0370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] d = new int[length];
        for (var e : updates) {
            int l = e[0], r = e[1], c = e[2];
            d[l] += c;
            if (r + 1 < length) {
                d[r + 1] -= c;
            }
        }
        for (int i = 1; i < length; ++i) {
            d[i] += d[i - 1];
        }
        return d;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0370 _tcSol = new Solution0370();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]");
        try {
            int length = 5;
            int[][] updates = new int[][]{new int[]{1, 3, 2}, new int[]{2, 4, 3}, new int[]{0, 2, -2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getModifiedArray(length, updates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-2,0,3,5,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]");
        try {
            int length = 10;
            int[][] updates = new int[][]{new int[]{2, 4, 6}, new int[]{5, 6, 8}, new int[]{1, 9, -4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getModifiedArray(length, updates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,-4,2,2,2,4,4,-4,-4,-4]");
        System.out.println();
    }
}