package com.leetcode.backtracking;

class Solution2056 {
    int n, m = 9, ans;
    int[][][] dist;
    int[][] end;
    String[] pieces;
    int[][] positions;
    int[][] rookDirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] bishopDirs = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    int[][] queenDirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int countCombinations(String[] pieces, int[][] positions) {
        n = pieces.length;
        dist = new int[n][m][m];
        end = new int[n][3];
        ans = 0;
        this.pieces = pieces;
        this.positions = positions;

        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i >= n) {
            ans++;
            return;
        }

        int x = positions[i][0], y = positions[i][1];
        resetDist(i);
        dist[i][x][y] = 0;
        end[i] = new int[] {x, y, 0};

        if (checkStop(i, x, y, 0)) {
            dfs(i + 1);
        }

        int[][] dirs = getDirs(pieces[i]);
        for (int[] dir : dirs) {
            resetDist(i);
            dist[i][x][y] = 0;
            int nx = x + dir[0], ny = y + dir[1], nt = 1;

            while (isValid(nx, ny) && checkPass(i, nx, ny, nt)) {
                dist[i][nx][ny] = nt;
                end[i] = new int[] {nx, ny, nt};
                if (checkStop(i, nx, ny, nt)) {
                    dfs(i + 1);
                }
                nx += dir[0];
                ny += dir[1];
                nt++;
            }
        }
    }

    private void resetDist(int i) {
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < m; k++) {
                dist[i][j][k] = -1;
            }
        }
    }

    private boolean checkStop(int i, int x, int y, int t) {
        for (int j = 0; j < i; j++) {
            if (dist[j][x][y] >= t) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPass(int i, int x, int y, int t) {
        for (int j = 0; j < i; j++) {
            if (dist[j][x][y] == t) {
                return false;
            }
            if (end[j][0] == x && end[j][1] == y && end[j][2] <= t) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int x, int y) {
        return x >= 1 && x < m && y >= 1 && y < m;
    }

    private int[][] getDirs(String piece) {
        char c = piece.charAt(0);
        return switch (c) {
            case 'r' -> rookDirs;
            case 'b' -> bishopDirs;
            default -> queenDirs;
        };
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2056 _tcSol = new Solution2056();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pieces = [\"rook\"], positions = [[1,1]]");
        try {
            String[] pieces = new String[]{"rook"};
            int[][] positions = new int[][]{new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCombinations(pieces, positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pieces = [\"queen\"], positions = [[1,1]]");
        try {
            String[] pieces = new String[]{"queen"};
            int[][] positions = new int[][]{new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCombinations(pieces, positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "pieces = [\"bishop\"], positions = [[4,3]]");
        try {
            String[] pieces = new String[]{"bishop"};
            int[][] positions = new int[][]{new int[]{4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCombinations(pieces, positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}
