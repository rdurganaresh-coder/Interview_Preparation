package com.leetcode.trees_tries;

class Solution1766_2 {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        List<Integer>[] f = new List[51];
        Deque<int[]>[] stks = new Deque[51];
        Arrays.setAll(f, k -> new ArrayList<>());
        Arrays.setAll(stks, k -> new ArrayDeque<>());
        for (int i = 1; i < 51; ++i) {
            for (int j = 1; j < 51; ++j) {
                if (gcd(i, j) == 1) {
                    f[i].add(j);
                }
            }
        }
        int[] ans = new int[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.peek();
            int i = cur[0], fa = cur[1], depth = cur[2], k = cur[3];
            if (k == 0) {
                int t = -1, mx = -1;
                for (int v : f[nums[i]]) {
                    Deque<int[]> s = stks[v];
                    if (!s.isEmpty() && s.peek()[1] > mx) {
                        t = s.peek()[0];
                        mx = s.peek()[1];
                    }
                }
                ans[i] = t;
            } else {
                int jprev = g[i].get(k - 1);
                if (jprev != fa) {
                    stks[nums[i]].pop();
                }
            }
            while (k < g[i].size() && g[i].get(k) == fa) {
                ++k;
            }
            if (k == g[i].size()) {
                stk.pop();
                continue;
            }
            int j = g[i].get(k);
            cur[3] = k + 1;
            stks[nums[i]].push(new int[] {i, depth});
            stk.push(new int[] {j, i, depth + 1, 0});
        }
        return ans;
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
        Solution1766_2 _tcSol = new Solution1766_2();
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
