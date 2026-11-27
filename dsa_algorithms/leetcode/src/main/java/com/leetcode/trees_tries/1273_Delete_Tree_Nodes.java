package com.leetcode.trees_tries;

class Solution1273 {
    private List<Integer>[] g;
    private int[] value;

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        g = new List[nodes];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < nodes; ++i) {
            g[parent[i]].add(i);
        }
        this.value = value;
        return dfs(0)[1];
    }

    private int[] dfs(int i) {
        int[] res = new int[] {value[i], 1};
        for (int j : g[i]) {
            int[] t = dfs(j);
            res[0] += t[0];
            res[1] += t[1];
        }
        if (res[0] == 0) {
            res[1] = 0;
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1273 _tcSol = new Solution1273();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]");
        try {
            int nodes = 7;
            int[] parent = new int[]{-1, 0, 0, 1, 2, 2, 2};
            int[] value = new int[]{1, -2, 4, 0, -2, -1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.deleteTreeNodes(nodes, parent, value)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-2]");
        try {
            int nodes = 7;
            int[] parent = new int[]{-1, 0, 0, 1, 2, 2, 2};
            int[] value = new int[]{1, -2, 4, 0, -2, -1, -2};
            System.out.println("  Output  : " + _tcShow(_tcSol.deleteTreeNodes(nodes, parent, value)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
