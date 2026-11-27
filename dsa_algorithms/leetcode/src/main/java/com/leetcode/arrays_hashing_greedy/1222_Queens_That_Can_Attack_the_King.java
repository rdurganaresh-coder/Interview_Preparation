package com.leetcode.arrays_hashing_greedy;

class Solution1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        final int n = 8;
        var s = new boolean[n][n];
        for (var q : queens) {
            s[q[0]][q[1]] = true;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int a = -1; a <= 1; ++a) {
            for (int b = -1; b <= 1; ++b) {
                if (a != 0 || b != 0) {
                    int x = king[0] + a, y = king[1] + b;
                    while (x >= 0 && x < n && y >= 0 && y < n) {
                        if (s[x][y]) {
                            ans.add(List.of(x, y));
                            break;
                        }
                        x += a;
                        y += b;
                    }
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
        Solution1222 _tcSol = new Solution1222();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]");
        try {
            int[][] queens = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{4, 0}, new int[]{0, 4}, new int[]{3, 3}, new int[]{2, 4}};
            int[] king = new int[]{0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.queensAttacktheKing(queens, king)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[1,0],[3,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]");
        try {
            int[][] queens = new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 4}, new int[]{3, 5}, new int[]{4, 4}, new int[]{4, 5}};
            int[] king = new int[]{3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.queensAttacktheKing(queens, king)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,2],[3,4],[4,4]]");
        System.out.println();
    }
}