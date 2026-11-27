package com.leetcode.arrays_hashing_greedy;

class Solution1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = target[0], y = target[1], z = target[2];
        int d = 0, e = 0, f = 0;
        for (var t : triplets) {
            int a = t[0], b = t[1], c = t[2];
            if (a <= x && b <= y && c <= z) {
                d = Math.max(d, a);
                e = Math.max(e, b);
                f = Math.max(f, c);
            }
        }
        return d == x && e == y && f == z;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1899 _tcSol = new Solution1899();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]");
        try {
            int[][] triplets = new int[][]{new int[]{2, 5, 3}, new int[]{1, 8, 4}, new int[]{1, 7, 5}};
            int[] target = new int[]{2, 7, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeTriplets(triplets, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "triplets = [[3,4,5],[4,5,6]], target = [3,2,5]");
        try {
            int[][] triplets = new int[][]{new int[]{3, 4, 5}, new int[]{4, 5, 6}};
            int[] target = new int[]{3, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeTriplets(triplets, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "triplets = [[2,5,3],[2,3,4],[1,2,5],[5,2,3]], target = [5,5,5]");
        try {
            int[][] triplets = new int[][]{new int[]{2, 5, 3}, new int[]{2, 3, 4}, new int[]{1, 2, 5}, new int[]{5, 2, 3}};
            int[] target = new int[]{5, 5, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeTriplets(triplets, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}