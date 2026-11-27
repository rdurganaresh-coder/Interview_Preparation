package com.leetcode.arrays_hashing_greedy;

class Solution2538_2 {
    public long maxOutput(int n, int[][] edges, int[] price) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        long[][] down = new long[n][2];
        long ans = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1], state = cur[2];
            if (state == 0) {
                stk.push(new int[] {i, fa, 1});
                for (int j : g[i]) {
                    if (j != fa) {
                        stk.push(new int[] {j, i, 0});
                    }
                }
            } else {
                long a = price[i], b = 0;
                for (int j : g[i]) {
                    if (j != fa) {
                        long c = down[j][0], d = down[j][1];
                        ans = Math.max(ans, Math.max(a + d, b + c));
                        a = Math.max(a, price[i] + c);
                        b = Math.max(b, price[i] + d);
                    }
                }
                down[i][0] = a;
                down[i][1] = b;
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
        Solution2538_2 _tcSol = new Solution2538_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, edges = [[0,1],[1,2],[1,3],[3,4],[3,5]], price = [9,8,7,6,10,5]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 4}, new int[]{3, 5}};
            int[] price = new int[]{9, 8, 7, 6, 10, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOutput(n, edges, price)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1],[1,2]], price = [1,1,1]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
            int[] price = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOutput(n, edges, price)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
