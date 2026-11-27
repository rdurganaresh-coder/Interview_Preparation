package com.leetcode.trees_tries;

class Solution2322_2 {
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int s = 0;
        for (int x : nums) {
            s ^= x;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j : g[i]) {
                int s1 = componentXor(nums, g, i, j);
                ans = Math.min(ans, collect(nums, g, i, j, s, s1));
            }
        }
        return ans;
    }

    private int componentXor(int[] nums, List<Integer>[] g, int root, int ban) {
        int n = nums.length;
        int[] sub = new int[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {root, ban, 0});
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
                int res = nums[i];
                for (int j : g[i]) {
                    if (j != fa) {
                        res ^= sub[j];
                    }
                }
                sub[i] = res;
            }
        }
        return sub[root];
    }

    private int collect(int[] nums, List<Integer>[] g, int root, int ban, int s, int s1) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] sub = new int[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {root, ban, 0});
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
                int res = nums[i];
                for (int j : g[i]) {
                    if (j != fa) {
                        int s2 = sub[j];
                        res ^= s2;
                        int mx = Math.max(Math.max(s ^ s1, s2), s1 ^ s2);
                        int mn = Math.min(Math.min(s ^ s1, s2), s1 ^ s2);
                        ans = Math.min(ans, mx - mn);
                    }
                }
                sub[i] = res;
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
        Solution2322_2 _tcSol = new Solution2322_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,5,5,4,11], edges = [[0,1],[1,2],[1,3],[3,4]]");
        try {
            int[] nums = new int[]{1, 5, 5, 4, 11};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{1, 3}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumScore(nums, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,5,2,4,4,2], edges = [[0,1],[1,2],[5,2],[4,3],[1,3]]");
        try {
            int[] nums = new int[]{5, 5, 2, 4, 4, 2};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{5, 2}, new int[]{4, 3}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumScore(nums, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
