package com.leetcode.graphs_shortest_path;

class BinarySumTrie3590 {
    int count;
    BinarySumTrie3590[] children = new BinarySumTrie3590[2];

    void add(int num, int delta, int bit) {
        count += delta;
        if (bit < 0) {
            return;
        }
        int b = (num >> bit) & 1;
        if (children[b] == null) {
            children[b] = new BinarySumTrie3590();
        }
        children[b].add(num, delta, bit - 1);
    }

    void collect(int prefix, int bit, List<Integer> output) {
        if (count == 0) {
            return;
        }
        if (bit < 0) {
            output.add(prefix);
            return;
        }
        if (children[0] != null) {
            children[0].collect(prefix, bit - 1, output);
        }
        if (children[1] != null) {
            children[1].collect(prefix | (1 << bit), bit - 1, output);
        }
    }

    boolean exists(int num, int bit) {
        if (count == 0) {
            return false;
        }
        if (bit < 0) {
            return true;
        }
        int b = (num >> bit) & 1;
        return children[b] != null && children[b].exists(num, bit - 1);
    }

    int findKth(int k, int bit) {
        if (k > count) {
            return -1;
        }
        if (bit < 0) {
            return 0;
        }
        int leftCount = children[0] == null ? 0 : children[0].count;
        if (k <= leftCount) {
            return children[0].findKth(k, bit - 1);
        }
        if (children[1] != null) {
            return (1 << bit) + children[1].findKth(k - leftCount, bit - 1);
        }
        return -1;
    }
}

class Solution3590 {
    private static final int BITS = 17;

    public int[] kthSmallest(int[] par, int[] vals, int[][] queries) {
        int n = par.length;
        List<Integer>[] tree = new List[n];
        Arrays.setAll(tree, i -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            tree[par[i]].add(i);
        }
        int[] pathXor = vals.clone();
        computeXor(0, 0, tree, pathXor);

        List<int[]>[] nodeQueries = new List[n];
        Arrays.setAll(nodeQueries, i -> new ArrayList<>());
        for (int i = 0; i < queries.length; ++i) {
            nodeQueries[queries[i][0]].add(new int[] {queries[i][1], i});
        }

        BinarySumTrie3590[] pool = new BinarySumTrie3590[n];
        int[] result = new int[queries.length];
        dfs(0, tree, pathXor, nodeQueries, pool, result);
        return result;
    }

    private void computeXor(int node, int acc, List<Integer>[] tree, int[] pathXor) {
        pathXor[node] ^= acc;
        for (int child : tree[node]) {
            computeXor(child, pathXor[node], tree, pathXor);
        }
    }

    private void dfs(int node, List<Integer>[] tree, int[] pathXor, List<int[]>[] nodeQueries,
        BinarySumTrie3590[] pool, int[] result) {
        pool[node] = new BinarySumTrie3590();
        pool[node].add(pathXor[node], 1, BITS);
        for (int child : tree[node]) {
            dfs(child, tree, pathXor, nodeQueries, pool, result);
            if (pool[node].count < pool[child].count) {
                BinarySumTrie3590 tmp = pool[node];
                pool[node] = pool[child];
                pool[child] = tmp;
            }
            List<Integer> vals = new ArrayList<>();
            pool[child].collect(0, BITS, vals);
            for (int val : vals) {
                if (!pool[node].exists(val, BITS)) {
                    pool[node].add(val, 1, BITS);
                }
            }
        }
        for (int[] q : nodeQueries[node]) {
            result[q[1]] = pool[node].count < q[0] ? -1 : pool[node].findKth(q[0], BITS);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3590 _tcSol = new Solution3590();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "par = [-1,0,0], vals = [1,1,1], queries = [[0,1],[0,2],[0,3]]");
        try {
            int[] par = new int[]{-1, 0, 0};
            int[] vals = new int[]{1, 1, 1};
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallest(par, vals, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "par = [-1,0,1], vals = [5,2,7], queries = [[0,1],[1,2],[1,3],[2,1]]");
        try {
            int[] par = new int[]{-1, 0, 1};
            int[] vals = new int[]{5, 2, 7};
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallest(par, vals, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,7,-1,0]");
        System.out.println();
    }
}
