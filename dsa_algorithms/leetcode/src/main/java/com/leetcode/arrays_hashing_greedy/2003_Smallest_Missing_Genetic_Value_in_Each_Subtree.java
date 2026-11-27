package com.leetcode.arrays_hashing_greedy;

class Solution2003 {
    private List<Integer>[] g;
    private boolean[] vis;
    private boolean[] has;
    private int[] nums;

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = nums.length;
        this.nums = nums;
        g = new List[n];
        vis = new boolean[n];
        has = new boolean[n + 2];
        Arrays.setAll(g, i -> new ArrayList<>());
        int idx = -1;
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                g[parents[i]].add(i);
            }
            if (nums[i] == 1) {
                idx = i;
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        if (idx == -1) {
            return ans;
        }
        for (int i = 2; idx != -1; idx = parents[idx]) {
            dfs(idx);
            while (has[i]) {
                ++i;
            }
            ans[idx] = i;
        }
        return ans;
    }

    private void dfs(int i) {
        if (vis[i]) {
            return;
        }
        vis[i] = true;
        if (nums[i] < has.length) {
            has[nums[i]] = true;
        }
        for (int j : g[i]) {
            dfs(j);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2003 _tcSol = new Solution2003();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "parents = [-1,0,0,2], nums = [1,2,3,4]");
        try {
            int[] parents = new int[]{-1, 0, 0, 2};
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestMissingValueSubtree(parents, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,1,1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "parents = [-1,0,1,0,3,3], nums = [5,4,6,2,1,3]");
        try {
            int[] parents = new int[]{-1, 0, 1, 0, 3, 3};
            int[] nums = new int[]{5, 4, 6, 2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestMissingValueSubtree(parents, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[7,1,1,4,2,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "parents = [-1,2,3,0,2,4,1], nums = [2,3,4,5,6,7,8]");
        try {
            int[] parents = new int[]{-1, 2, 3, 0, 2, 4, 1};
            int[] nums = new int[]{2, 3, 4, 5, 6, 7, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestMissingValueSubtree(parents, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,1,1,1,1,1]");
        System.out.println();
    }
}
