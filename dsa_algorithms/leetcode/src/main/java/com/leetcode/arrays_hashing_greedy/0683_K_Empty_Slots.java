package com.leetcode.arrays_hashing_greedy;

class Solution0683 {
    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        BinaryIndexedTree0683 tree = new BinaryIndexedTree0683(n);
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            int x = bulbs[i - 1];
            tree.update(x, 1);
            vis[x] = true;
            int y = x - k - 1;
            if (y > 0 && vis[y] && tree.query(x - 1) - tree.query(y) == 0) {
                return i;
            }
            y = x + k + 1;
            if (y <= n && vis[y] && tree.query(y - 1) - tree.query(x) == 0) {
                return i;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0683 _tcSol = new Solution0683();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "bulbs = [1,3,2], k = 1");
        try {
            int[] bulbs = new int[]{1, 3, 2};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kEmptySlots(bulbs, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "bulbs = [1,2,3], k = 1");
        try {
            int[] bulbs = new int[]{1, 2, 3};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kEmptySlots(bulbs, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}

class BinaryIndexedTree0683 {
    private int n;
    private int[] c;

    public BinaryIndexedTree0683(int n) {
        this.n = n;
        this.c = new int[n + 1];
    }

    public void update(int x, int delta) {
        for (; x <= n; x += x & -x) {
            c[x] += delta;
        }
    }

    public int query(int x) {
        int s = 0;
        for (; x > 0; x -= x & -x) {
            s += c[x];
        }
        return s;
    }
}