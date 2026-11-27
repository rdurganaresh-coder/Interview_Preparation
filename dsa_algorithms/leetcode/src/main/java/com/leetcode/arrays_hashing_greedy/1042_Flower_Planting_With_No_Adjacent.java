package com.leetcode.arrays_hashing_greedy;

class Solution1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var p : paths) {
            int x = p[0] - 1, y = p[1] - 1;
            g[x].add(y);
            g[y].add(x);
        }
        int[] ans = new int[n];
        boolean[] used = new boolean[5];
        for (int x = 0; x < n; ++x) {
            Arrays.fill(used, false);
            for (int y : g[x]) {
                used[ans[y]] = true;
            }
            for (int c = 1; c < 5; ++c) {
                if (!used[c]) {
                    ans[x] = c;
                    break;
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
        Solution1042 _tcSol = new Solution1042();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, paths = [[1,2],[2,3],[3,1]]");
        try {
            int n = 3;
            int[][] paths = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.gardenNoAdj(n, paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, paths = [[1,2],[3,4]]");
        try {
            int n = 4;
            int[][] paths = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.gardenNoAdj(n, paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,1,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]");
        try {
            int n = 4;
            int[][] paths = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 1}, new int[]{1, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.gardenNoAdj(n, paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,4]");
        System.out.println();
    }
}