package com.leetcode.arrays_hashing_greedy;

class Solution0789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int tx = target[0], ty = target[1];
        for (var g : ghosts) {
            int x = g[0], y = g[1];
            if (Math.abs(tx - x) + Math.abs(ty - y) <= Math.abs(tx) + Math.abs(ty)) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0789 _tcSol = new Solution0789();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ghosts = [[1,0],[0,3]], target = [0,1]");
        try {
            int[][] ghosts = new int[][]{new int[]{1, 0}, new int[]{0, 3}};
            int[] target = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.escapeGhosts(ghosts, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ghosts = [[1,0]], target = [2,0]");
        try {
            int[][] ghosts = new int[][]{new int[]{1, 0}};
            int[] target = new int[]{2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.escapeGhosts(ghosts, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "ghosts = [[2,0]], target = [1,0]");
        try {
            int[][] ghosts = new int[][]{new int[]{2, 0}};
            int[] target = new int[]{1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.escapeGhosts(ghosts, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}