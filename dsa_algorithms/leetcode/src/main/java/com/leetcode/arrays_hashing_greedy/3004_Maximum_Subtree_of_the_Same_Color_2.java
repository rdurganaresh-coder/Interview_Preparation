package com.leetcode.arrays_hashing_greedy;

class Solution3004_2 {
    public int maximumSubtreeSize(int[][] edges, int[] colors) {
        int n = edges.length + 1;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int[] size = new int[n];
        Arrays.fill(size, 1);
        boolean[] ok = new boolean[n];
        int ans = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int a = cur[0], fa = cur[1], state = cur[2];
            if (state == 0) {
                stk.push(new int[] {a, fa, 1});
                for (int b : g[a]) {
                    if (b != fa) {
                        stk.push(new int[] {b, a, 0});
                    }
                }
            } else {
                boolean good = true;
                for (int b : g[a]) {
                    if (b != fa) {
                        good = good && colors[a] == colors[b] && ok[b];
                        size[a] += size[b];
                    }
                }
                if (good) {
                    ans = Math.max(ans, size[a]);
                }
                ok[a] = good;
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
        Solution3004_2 _tcSol = new Solution3004_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[0,3]], colors = [1,1,2,3]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}};
            int[] colors = new int[]{1, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubtreeSize(edges, colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[0,3]], colors = [1,1,1,1]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}};
            int[] colors = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubtreeSize(edges, colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "edges = [[0,1],[0,2],[2,3],[2,4]], colors = [1,2,3,3,3]");
        try {
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{2, 4}};
            int[] colors = new int[]{1, 2, 3, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubtreeSize(edges, colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
