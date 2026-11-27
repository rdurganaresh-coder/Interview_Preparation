package com.leetcode.trees_tries;

class Solution1719 {
    public int checkWays(int[][] pairs) {
        boolean[][] g = new boolean[510][510];
        List<Integer>[] v = new List[510];
        Arrays.setAll(v, k -> new ArrayList<>());
        for (int[] p : pairs) {
            int x = p[0], y = p[1];
            g[x][y] = true;
            g[y][x] = true;
            v[x].add(y);
            v[y].add(x);
        }
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < 510; ++i) {
            if (!v[i].isEmpty()) {
                nodes.add(i);
                g[i][i] = true;
            }
        }
        nodes.sort(Comparator.comparingInt(a -> v[a].size()));
        boolean equal = false;
        int root = 0;
        for (int i = 0; i < nodes.size(); ++i) {
            int x = nodes.get(i);
            int j = i + 1;
            for (; j < nodes.size() && !g[x][nodes.get(j)]; ++j)
                ;
            if (j < nodes.size()) {
                int y = nodes.get(j);
                if (v[x].size() == v[y].size()) {
                    equal = true;
                }
                for (int z : v[x]) {
                    if (!g[y][z]) {
                        return 0;
                    }
                }
            } else {
                ++root;
            }
        }
        if (root > 1) {
            return 0;
        }
        return equal ? 2 : 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1719 _tcSol = new Solution1719();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pairs = [[1,2],[2,3]]");
        try {
            int[][] pairs = new int[][]{new int[]{1, 2}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkWays(pairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pairs = [[1,2],[2,3],[1,3]]");
        try {
            int[][] pairs = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkWays(pairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "pairs = [[1,2],[2,3],[2,4],[1,5]]");
        try {
            int[][] pairs = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 4}, new int[]{1, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkWays(pairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}