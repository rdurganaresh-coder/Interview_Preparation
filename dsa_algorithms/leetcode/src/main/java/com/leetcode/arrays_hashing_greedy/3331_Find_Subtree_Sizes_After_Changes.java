package com.leetcode.arrays_hashing_greedy;

class Solution3331 {
    private List<Integer>[] g;
    private List<Integer>[] d;
    private char[] s;
    private int[] ans;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = s.length();
        g = new List[n];
        d = new List[26];
        this.s = s.toCharArray();
        Arrays.setAll(g, k -> new ArrayList<>());
        Arrays.setAll(d, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parent[i]].add(i);
        }
        ans = new int[n];
        dfs(0, -1);
        return ans;
    }

    private void dfs(int i, int fa) {
        ans[i] = 1;
        int idx = s[i] - 'a';
        d[idx].add(i);
        for (int j : g[i]) {
            dfs(j, i);
        }
        int k = d[idx].size() > 1 ? d[idx].get(d[idx].size() - 2) : fa;
        if (k >= 0) {
            ans[k] += ans[i];
        }
        d[idx].remove(d[idx].size() - 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3331 _tcSol = new Solution3331();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "parent = [-1,0,0,1,1,1], s = \"abaabc\"");
        try {
            int[] parent = new int[]{-1, 0, 0, 1, 1, 1};
            String s = "abaabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubtreeSizes(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,3,1,1,1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "parent = [-1,0,4,0,1], s = \"abbba\"");
        try {
            int[] parent = new int[]{-1, 0, 4, 0, 1};
            String s = "abbba";
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubtreeSizes(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,2,1,1,1]");
        System.out.println();
    }
}
