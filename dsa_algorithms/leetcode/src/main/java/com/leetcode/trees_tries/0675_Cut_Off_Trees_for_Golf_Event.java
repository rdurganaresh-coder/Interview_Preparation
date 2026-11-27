package com.leetcode.trees_tries;

class Solution0675 {
    private int[] dist = new int[3600];
    private List<List<Integer>> forest;
    private int m;
    private int n;

    public int cutOffTree(List<List<Integer>> forest) {
        this.forest = forest;
        m = forest.size();
        n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[] {forest.get(i).get(j), i * n + j});
                }
            }
        }
        trees.sort(Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int start = 0;
        for (int[] tree : trees) {
            int end = tree[1];
            int t = bfs(start, end);
            if (t == -1) {
                return -1;
            }
            ans += t;
            start = end;
        }
        return ans;
    }

    private int bfs(int start, int end) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[] {f(start, end), start});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int state = q.poll()[1];
            if (state == end) {
                return dist[state];
            }
            for (int k = 0; k < 4; ++k) {
                int x = state / n + dirs[k];
                int y = state % n + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && forest.get(x).get(y) > 0) {
                    if (dist[x * n + y] > dist[state] + 1) {
                        dist[x * n + y] = dist[state] + 1;
                        q.offer(new int[] {dist[x * n + y] + f(x * n + y, end), x * n + y});
                    }
                }
            }
        }
        return -1;
    }

    private int f(int start, int end) {
        int a = start / n;
        int b = start % n;
        int c = end / n;
        int d = end % n;
        return Math.abs(a - c) + Math.abs(b - d);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution0675 _tcSol = new Solution0675();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "forest = [[1,2,3],[0,0,4],[7,6,5]]");
        try {
            List<List<Integer>> forest = _tcL(_tcL(1, 2, 3), _tcL(0, 0, 4), _tcL(7, 6, 5));
            System.out.println("  Output  : " + _tcShow(_tcSol.cutOffTree(forest)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "forest = [[1,2,3],[0,0,0],[7,6,5]]");
        try {
            List<List<Integer>> forest = _tcL(_tcL(1, 2, 3), _tcL(0, 0, 0), _tcL(7, 6, 5));
            System.out.println("  Output  : " + _tcShow(_tcSol.cutOffTree(forest)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "forest = [[2,3,4],[0,0,5],[8,7,6]]");
        try {
            List<List<Integer>> forest = _tcL(_tcL(2, 3, 4), _tcL(0, 0, 5), _tcL(8, 7, 6));
            System.out.println("  Output  : " + _tcShow(_tcSol.cutOffTree(forest)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}