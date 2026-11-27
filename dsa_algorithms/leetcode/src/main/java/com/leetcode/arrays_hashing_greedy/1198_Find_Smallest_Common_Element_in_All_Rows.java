package com.leetcode.arrays_hashing_greedy;

class Solution1198 {
    public int smallestCommonElement(int[][] mat) {
        int[] cnt = new int[10001];
        for (var row : mat) {
            for (int x : row) {
                if (++cnt[x] == mat.length) {
                    return x;
                }
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1198 _tcSol = new Solution1198();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 5, 8, 10}, new int[]{3, 5, 7, 9, 11}, new int[]{1, 3, 5, 7, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestCommonElement(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1,2,3],[2,3,4],[2,3,5]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 2, 3}, new int[]{2, 3, 4}, new int[]{2, 3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestCommonElement(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}