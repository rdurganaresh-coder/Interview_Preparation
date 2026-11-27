package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree3161 {
    private int n;
    private int[] c;

    public BinaryIndexedTree3161(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int v) {
        while (x <= n) {
            c[x] = Math.max(c[x], v);
            x += x & -x;
        }
    }

    public int query(int x) {
        int mx = 0;
        while (x > 0) {
            mx = Math.max(mx, c[x]);
            x -= x & -x;
        }
        return mx;
    }
}

class Solution3161 {
    public List<Boolean> getResults(int[][] queries) {
        int m = 0;
        for (int[] q : queries) {
            m = Math.max(m, q[1]);
        }
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        ts.add(m + 1);
        for (int[] q : queries) {
            if (q[0] == 1) {
                ts.add(q[1]);
            }
        }
        BinaryIndexedTree3161 tree = new BinaryIndexedTree3161(m + 1);
        int pre = 0;
        for (int x : ts) {
            if (x > 0) {
                tree.update(x, x - pre);
            }
            pre = x;
        }
        List<Boolean> ans = new ArrayList<>();
        for (int i = queries.length - 1; i >= 0; --i) {
            int[] q = queries[i];
            int x = q[1];
            if (q[0] == 1) {
                int nxt = ts.higher(x);
                tree.update(nxt, nxt - ts.lower(x));
                ts.remove(x);
            } else {
                int p = ts.floor(x);
                ans.add(tree.query(p) >= q[2] || x - p >= q[2]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3161 _tcSol = new Solution3161();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queries = [[1,2],[2,3,3],[2,3,1],[2,2,2]]");
        try {
            int[][] queries = new int[][]{new int[]{1, 2}, new int[]{2, 3, 3}, new int[]{2, 3, 1}, new int[]{2, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getResults(queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,true,true]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queries = [[1,7],[2,7,6],[1,2],[2,7,5],[2,7,6]]");
        try {
            int[][] queries = new int[][]{new int[]{1, 7}, new int[]{2, 7, 6}, new int[]{1, 2}, new int[]{2, 7, 5}, new int[]{2, 7, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getResults(queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,true,false]");
        System.out.println();
    }
}
