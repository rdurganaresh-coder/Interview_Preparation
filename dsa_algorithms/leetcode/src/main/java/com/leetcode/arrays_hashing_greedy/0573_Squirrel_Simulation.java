package com.leetcode.arrays_hashing_greedy;

import static java.lang.Math.*;

class Solution0573 {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int tr = tree[0], tc = tree[1];
        int sr = squirrel[0], sc = squirrel[1];
        int s = 0;
        for (var e : nuts) {
            s += abs(e[0] - tr) + abs(e[1] - tc);
        }
        s <<= 1;
        int ans = Integer.MAX_VALUE;
        for (var e : nuts) {
            int a = abs(e[0] - tr) + abs(e[1] - tc);
            int b = abs(e[0] - sr) + abs(e[1] - sc);
            ans = min(ans, s - a + b);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0573 _tcSol = new Solution0573();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "height = 5, width = 7, tree = [2,2], squirrel = [4,4], nuts = [[3,0], [2,5]]");
        try {
            int height = 5;
            int width = 7;
            int[] tree = new int[]{2, 2};
            int[] squirrel = new int[]{4, 4};
            int[][] nuts = new int[][]{new int[]{3, 0}, new int[]{2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDistance(height, width, tree, squirrel, nuts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "height = 1, width = 3, tree = [0,1], squirrel = [0,0], nuts = [[0,2]]");
        try {
            int height = 1;
            int width = 3;
            int[] tree = new int[]{0, 1};
            int[] squirrel = new int[]{0, 0};
            int[][] nuts = new int[][]{new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDistance(height, width, tree, squirrel, nuts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
