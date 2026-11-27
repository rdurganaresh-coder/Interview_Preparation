package com.leetcode.arrays_hashing_greedy;

class Solution2445 {
    private int[] tree;

    public int numberOfNodes(int n, int[] queries) {
        tree = new int[n + 1];
        int[] cnt = new int[n + 1];
        for (int v : queries) {
            ++cnt[v];
        }
        for (int i = 0; i < n + 1; ++i) {
            if (cnt[i] % 2 == 1) {
                dfs(i);
            }
        }
        int ans = 0;
        for (int i = 0; i < n + 1; ++i) {
            ans += tree[i];
        }
        return ans;
    }

    private void dfs(int i) {
        if (i >= tree.length) {
            return;
        }
        tree[i] ^= 1;
        dfs(i << 1);
        dfs(i << 1 | 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2445 _tcSol = new Solution2445();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5 , queries = [1,2,5]");
        try {
            int n = 5;
            int[] queries = new int[]{1, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfNodes(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, queries = [2,3,3]");
        try {
            int n = 3;
            int[] queries = new int[]{2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfNodes(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}