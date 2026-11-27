package com.leetcode.graphs_shortest_path;

class Solution1036 {
    private final int n = (int) 1e6;
    private int m;
    private Set<Long> s = new HashSet<>();
    private final int[] dirs = {-1, 0, 1, 0, -1};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (var b : blocked) {
            s.add(f(b[0], b[1]));
        }
        m = blocked.length * blocked.length / 2;
        int sx = source[0], sy = source[1];
        int tx = target[0], ty = target[1];
        return dfs(sx, sy, tx, ty, new HashSet<>()) && dfs(tx, ty, sx, sy, new HashSet<>());
    }

    private boolean dfs(int sx, int sy, int tx, int ty, Set<Long> vis) {
        if (vis.size() > m) {
            return true;
        }
        for (int k = 0; k < 4; ++k) {
            int x = sx + dirs[k], y = sy + dirs[k + 1];
            if (x >= 0 && x < n && y >= 0 && y < n) {
                if (x == tx && y == ty) {
                    return true;
                }
                long key = f(x, y);
                if (!s.contains(key) && vis.add(key) && dfs(x, y, tx, ty, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private long f(int i, int j) {
        return (long) i * n + j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1036 _tcSol = new Solution1036();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]");
        try {
            int[][] blocked = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
            int[] source = new int[]{0, 0};
            int[] target = new int[]{0, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.isEscapePossible(blocked, source, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "blocked = [], source = [0,0], target = [999999,999999]");
        try {
            int[][] blocked = new int[][]{};
            int[] source = new int[]{0, 0};
            int[] target = new int[]{999999, 999999};
            System.out.println("  Output  : " + _tcShow(_tcSol.isEscapePossible(blocked, source, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}