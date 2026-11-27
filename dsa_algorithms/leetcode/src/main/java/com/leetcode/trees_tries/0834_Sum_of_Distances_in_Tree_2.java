package com.leetcode.trees_tries;

class Solution0834_2 {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int[] ans = new int[n];
        int[] size = new int[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0, 0});
        while (!stk.isEmpty()) {
            int[] f = stk.pop();
            int i = f[0], fa = f[1], d = f[2], state = f[3];
            if (state == 0) {
                ans[0] += d;
                stk.push(new int[] {i, fa, d, 1});
                for (int j : g[i]) {
                    if (j != fa) {
                        stk.push(new int[] {j, i, d + 1, 0});
                    }
                }
            } else {
                size[i] = 1;
                for (int j : g[i]) {
                    if (j != fa) {
                        size[i] += size[j];
                    }
                }
            }
        }
        Deque<int[]> walk = new ArrayDeque<>();
        walk.push(new int[] {0, -1, ans[0]});
        while (!walk.isEmpty()) {
            int[] f = walk.pop();
            int i = f[0], fa = f[1], t = f[2];
            ans[i] = t;
            for (int j : g[i]) {
                if (j != fa) {
                    walk.push(new int[] {j, i, t - size[j] + n - size[j]});
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
        Solution0834_2 _tcSol = new Solution0834_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{2, 4}, new int[]{2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfDistancesInTree(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[8,12,6,10,10,10]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, edges = []");
        try {
            int n = 1;
            int[][] edges = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfDistancesInTree(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, edges = [[1,0]]");
        try {
            int n = 2;
            int[][] edges = new int[][]{new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfDistancesInTree(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();
    }
}
