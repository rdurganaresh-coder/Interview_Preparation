package com.leetcode.arrays_hashing_greedy;

class Solution1691 {
    public int maxHeight(int[][] cuboids) {
        for (var c : cuboids) {
            Arrays.sort(c);
        }
        Arrays.sort(cuboids,
            (a, b) -> a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]);
        int n = cuboids.length;
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            f[i] += cuboids[i][2];
        }
        return Arrays.stream(f).max().getAsInt();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1691 _tcSol = new Solution1691();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cuboids = [[50,45,20],[95,37,53],[45,23,12]]");
        try {
            int[][] cuboids = new int[][]{new int[]{50, 45, 20}, new int[]{95, 37, 53}, new int[]{45, 23, 12}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHeight(cuboids)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "190");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cuboids = [[38,25,45],[76,35,3]]");
        try {
            int[][] cuboids = new int[][]{new int[]{38, 25, 45}, new int[]{76, 35, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHeight(cuboids)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "76");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "cuboids = [[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]");
        try {
            int[][] cuboids = new int[][]{new int[]{7, 11, 17}, new int[]{7, 17, 11}, new int[]{11, 7, 17}, new int[]{11, 17, 7}, new int[]{17, 7, 11}, new int[]{17, 11, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHeight(cuboids)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "102");
        System.out.println();
    }
}