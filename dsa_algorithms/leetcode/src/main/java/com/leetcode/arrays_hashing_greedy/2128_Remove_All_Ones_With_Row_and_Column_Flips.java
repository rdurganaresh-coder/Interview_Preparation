package com.leetcode.arrays_hashing_greedy;

class Solution2128 {
    public boolean removeOnes(int[][] grid) {
        Set<String> s = new HashSet<>();
        int n = grid[0].length;
        for (var row : grid) {
            var cs = new char[n];
            for (int i = 0; i < n; ++i) {
                cs[i] = (char) (row[0] ^ row[i]);
            }
            s.add(String.valueOf(cs));
        }
        return s.size() == 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2128 _tcSol = new Solution2128();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,1,0],[1,0,1],[0,1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 0}, new int[]{1, 0, 1}, new int[]{0, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOnes(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[1,1,0],[0,0,0],[0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOnes(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[0]]");
        try {
            int[][] grid = new int[][]{new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeOnes(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}