package com.leetcode.arrays_hashing_greedy;

class Solution1861 {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] ans = new char[n][m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[j][m - i - 1] = boxGrid[i][j];
            }
        }
        for (int j = 0; j < m; ++j) {
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; --i) {
                if (ans[i][j] == '*') {
                    q.clear();
                } else if (ans[i][j] == '.') {
                    q.offer(i);
                } else if (!q.isEmpty()) {
                    ans[q.pollFirst()][j] = '#';
                    ans[i][j] = '.';
                    q.offer(i);
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
        Solution1861 _tcSol = new Solution1861();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "boxGrid = [[\"#\",\".\",\"#\"]]");
        try {
            char[][] boxGrid = new char[][]{new char[]{'#', '.', '#'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.rotateTheBox(boxGrid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\".\"], [\"#\"], [\"#\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "boxGrid = [[\"#\",\".\",\"*\",\".\"], [\"#\",\"#\",\"*\",\".\"]]");
        try {
            char[][] boxGrid = new char[][]{new char[]{'#', '.', '*', '.'}, new char[]{'#', '#', '*', '.'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.rotateTheBox(boxGrid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"#\",\".\"], [\"#\",\"#\"], [\"*\",\"*\"], [\".\",\".\"]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "boxGrid = [[\"#\",\"#\",\"*\",\".\",\"*\",\".\"], [\"#\",\"#\",\"#\",\"*\",\".\",\".\"], [\"#\",\"#\",\"#\",\".\",\"#\",\".\"]]");
        try {
            char[][] boxGrid = new char[][]{new char[]{'#', '#', '*', '.', '*', '.'}, new char[]{'#', '#', '#', '*', '.', '.'}, new char[]{'#', '#', '#', '.', '#', '.'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.rotateTheBox(boxGrid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\".\",\"#\",\"#\"], [\".\",\"#\",\"#\"], [\"#\",\"#\",\"*\"], [\"#\",\"*\",\".\"], [\"#\",\".\",\"*\"], [\"#\",\".\",\".\"]]");
        System.out.println();
    }
}
