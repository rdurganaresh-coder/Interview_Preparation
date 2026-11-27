package com.leetcode.trees_tries;

class Solution1766 {
    private List<Integer>[] g;
    private List<Integer>[] f;
    private Deque<int[]>[] stks;
    private int[] nums;
    private int[] ans;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        f = new List[51];
        stks = new Deque[51];
        Arrays.setAll(f, k -> new ArrayList<>());
        Arrays.setAll(stks, k -> new ArrayDeque<>());
        for (int i = 1; i < 51; ++i) {
            for (int j = 1; j < 51; ++j) {
                if (gcd(i, j) == 1) {
                    f[i].add(j);
                }
            }
        }
        this.nums = nums;
        ans = new int[n];
        dfs(0, -1, 0);
        return ans;
    }

    private void dfs(int i, int fa, int depth) {
        int t = -1, k = -1;
        for (int v : f[nums[i]]) {
            var stk = stks[v];
            if (!stk.isEmpty() && stk.peek()[1] > k) {
                t = stk.peek()[0];
                k = stk.peek()[1];
            }
        }
        ans[i] = t;
        for (int j : g[i]) {
            if (j != fa) {
                stks[nums[i]].push(new int[] {i, depth});
                dfs(j, i, depth + 1);
                stks[nums[i]].pop();
            }
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1766 _tcSol = new Solution1766();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]]");
        try {
            int[] nums = new int[]{2, 3, 3, 2};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getCoprimes(nums, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,0,0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]");
        try {
            int[] nums = new int[]{5, 6, 10, 2, 3, 6, 15};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 5}, new int[]{2, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getCoprimes(nums, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,0,-1,0,0,0,-1]");
        System.out.println();
    }
}
