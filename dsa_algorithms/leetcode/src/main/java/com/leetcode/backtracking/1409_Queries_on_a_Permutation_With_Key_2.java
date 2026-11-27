package com.leetcode.backtracking;

class BinaryIndexedTree1409_2 {
    private int n;
    private int[] c;

    public BinaryIndexedTree1409_2(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= lowbit(x);
        }
        return s;
    }

    public static int lowbit(int x) {
        return x & -x;
    }
}

class Solution1409_2 {
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        BinaryIndexedTree1409_2 tree = new BinaryIndexedTree1409_2(m + n);
        int[] pos = new int[m + 1];
        for (int i = 1; i <= m; ++i) {
            pos[i] = n + i;
            tree.update(n + i, 1);
        }
        int[] ans = new int[n];
        int k = 0;
        for (int i = 0; i < n; ++i) {
            int v = queries[i];
            int j = pos[v];
            tree.update(j, -1);
            ans[k++] = tree.query(j);
            pos[v] = n - i;
            tree.update(n - i, 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1409_2 _tcSol = new Solution1409_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queries = [3,1,2,1], m = 5");
        try {
            int[] queries = new int[]{3, 1, 2, 1};
            int m = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.processQueries(queries, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queries = [4,1,2,2], m = 4");
        try {
            int[] queries = new int[]{4, 1, 2, 2};
            int m = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.processQueries(queries, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,2,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "queries = [7,5,5,8,3], m = 8");
        try {
            int[] queries = new int[]{7, 5, 5, 8, 3};
            int m = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.processQueries(queries, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,5,0,7,5]");
        System.out.println();
    }
}