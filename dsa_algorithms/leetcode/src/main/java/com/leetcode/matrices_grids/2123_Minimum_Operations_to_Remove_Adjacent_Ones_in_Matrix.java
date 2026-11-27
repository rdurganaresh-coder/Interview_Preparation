package com.leetcode.matrices_grids;

class Solution2123 {
    private Map<Integer, List<Integer>> g = new HashMap<>();
    private Set<Integer> vis = new HashSet<>();
    private int[] match;

    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i + j) % 2 == 1 && grid[i][j] == 1) {
                    int x = i * n + j;
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        g.computeIfAbsent(x, z -> new ArrayList<>()).add(x + n);
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        g.computeIfAbsent(x, z -> new ArrayList<>()).add(x - n);
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        g.computeIfAbsent(x, z -> new ArrayList<>()).add(x + 1);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        g.computeIfAbsent(x, z -> new ArrayList<>()).add(x - 1);
                    }
                }
            }
        }
        match = new int[m * n];
        Arrays.fill(match, -1);
        int ans = 0;
        for (int i : g.keySet()) {
            ans += find(i);
            vis.clear();
        }
        return ans;
    }

    private int find(int i) {
        for (int j : g.get(i)) {
            if (vis.add(j)) {
                if (match[j] == -1 || find(match[j]) == 1) {
                    match[j] = i;
                    return 1;
                }
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2123 _tcSol = new Solution2123();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,1,0],[0,1,1],[1,1,1]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 1, 0}, new int[]{0, 1, 1}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,0,0],[0,0,0],[0,0,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[0,1],[1,0]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}