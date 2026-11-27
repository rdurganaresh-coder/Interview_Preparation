package com.leetcode.arrays_hashing_greedy;

class Solution0886 {
    private List<Integer>[] g;
    private int[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        g = new List[n];
        color = new int[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : dislikes) {
            int a = e[0] - 1, b = e[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }
        for (int i = 0; i < n; ++i) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int i, int c) {
        color[i] = c;
        for (int j : g[i]) {
            if (color[j] == c) {
                return false;
            }
            if (color[j] == 0 && !dfs(j, 3 - c)) {
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
        Solution0886 _tcSol = new Solution0886();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, dislikes = [[1,2],[1,3],[2,4]]");
        try {
            int n = 4;
            int[][] dislikes = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.possibleBipartition(n, dislikes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, dislikes = [[1,2],[1,3],[2,3]]");
        try {
            int n = 3;
            int[][] dislikes = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.possibleBipartition(n, dislikes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
