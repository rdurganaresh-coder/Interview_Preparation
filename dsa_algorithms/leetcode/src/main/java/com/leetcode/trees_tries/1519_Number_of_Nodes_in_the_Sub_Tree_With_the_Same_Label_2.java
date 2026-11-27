package com.leetcode.trees_tries;

class Solution1519_2 {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int[] ans = new int[n];
        int[] cnt = new int[26];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1], state = cur[2];
            int k = labels.charAt(i) - 'a';
            if (state == 0) {
                ans[i] -= cnt[k];
                cnt[k]++;
                stk.push(new int[] {i, fa, 1});
                for (int j : g[i]) {
                    if (j != fa) {
                        stk.push(new int[] {j, i, 0});
                    }
                }
            } else {
                ans[i] += cnt[k];
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
        Solution1519_2 _tcSol = new Solution1519_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = \"abaedcd\"");
        try {
            int n = 7;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 4}, new int[]{1, 5}, new int[]{2, 3}, new int[]{2, 6}};
            String labels = "abaedcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubTrees(n, edges, labels)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,1,1,1,1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1],[1,2],[0,3]], labels = \"bbbb\"");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 3}};
            String labels = "bbbb";
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubTrees(n, edges, labels)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,2,1,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = \"aabab\"");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{0, 4}};
            String labels = "aabab";
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubTrees(n, edges, labels)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,1,1,1]");
        System.out.println();
    }
}
