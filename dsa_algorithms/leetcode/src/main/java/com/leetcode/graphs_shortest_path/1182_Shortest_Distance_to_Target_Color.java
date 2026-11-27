package com.leetcode.graphs_shortest_path;

class Solution1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        final int inf = 1 << 30;
        int[][] right = new int[n + 1][3];
        Arrays.fill(right[n], inf);
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < 3; ++j) {
                right[i][j] = right[i + 1][j];
            }
            right[i][colors[i] - 1] = i;
        }
        int[][] left = new int[n + 1][3];
        Arrays.fill(left[0], -inf);
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 3; ++j) {
                left[i][j] = left[i - 1][j];
            }
            left[i][colors[i - 1] - 1] = i - 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int i = q[0], c = q[1] - 1;
            int d = Math.min(i - left[i + 1][c], right[i][c] - i);
            ans.add(d > n ? -1 : d);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1182 _tcSol = new Solution1182();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]");
        try {
            int[] colors = new int[]{1, 1, 2, 1, 3, 2, 2, 3, 3};
            int[][] queries = new int[][]{new int[]{1, 3}, new int[]{2, 2}, new int[]{6, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistanceColor(colors, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,0,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "colors = [1,2], queries = [[0,3]]");
        try {
            int[] colors = new int[]{1, 2};
            int[][] queries = new int[][]{new int[]{0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistanceColor(colors, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1]");
        System.out.println();
    }
}