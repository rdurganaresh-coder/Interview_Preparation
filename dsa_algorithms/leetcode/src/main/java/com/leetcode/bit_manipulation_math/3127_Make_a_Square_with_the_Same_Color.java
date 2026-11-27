package com.leetcode.bit_manipulation_math;

class Solution3127 {
    public boolean canMakeSquare(char[][] grid) {
        final int[] dirs = {0, 0, 1, 1, 0};
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                int cnt1 = 0, cnt2 = 0;
                for (int k = 0; k < 4; ++k) {
                    int x = i + dirs[k], y = j + dirs[k + 1];
                    cnt1 += grid[x][y] == 'W' ? 1 : 0;
                    cnt2 += grid[x][y] == 'B' ? 1 : 0;
                }
                if (cnt1 != cnt2) {
                    return true;
                }
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3127 _tcSol = new Solution3127();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[\"B\",\"W\",\"B\"],[\"B\",\"W\",\"W\"],[\"B\",\"W\",\"B\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'B', 'W', 'B'}, new char[]{'B', 'W', 'W'}, new char[]{'B', 'W', 'B'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeSquare(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[\"B\",\"W\",\"B\"],[\"W\",\"B\",\"W\"],[\"B\",\"W\",\"B\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'B', 'W', 'B'}, new char[]{'W', 'B', 'W'}, new char[]{'B', 'W', 'B'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeSquare(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[\"B\",\"W\",\"B\"],[\"B\",\"W\",\"W\"],[\"B\",\"W\",\"W\"]]");
        try {
            char[][] grid = new char[][]{new char[]{'B', 'W', 'B'}, new char[]{'B', 'W', 'W'}, new char[]{'B', 'W', 'W'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeSquare(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}