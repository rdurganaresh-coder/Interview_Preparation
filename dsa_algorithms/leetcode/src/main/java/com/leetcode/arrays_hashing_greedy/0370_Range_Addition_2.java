package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree0370_2 {
    private int n;
    private int[] c;

    public BinaryIndexedTree0370_2(int n) {
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

class Solution0370_2 {
    public int[] getModifiedArray(int length, int[][] updates) {
        var tree = new BinaryIndexedTree0370_2(length);
        for (var e : updates) {
            int l = e[0], r = e[1], c = e[2];
            tree.update(l + 1, c);
            tree.update(r + 2, -c);
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; ++i) {
            ans[i] = tree.query(i + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0370_2 _tcSol = new Solution0370_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]");
        try {
            int length = 5;
            int[][] updates = new int[][]{new int[]{1, 3, 2}, new int[]{2, 4, 3}, new int[]{0, 2, -2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getModifiedArray(length, updates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-2,0,3,5,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]");
        try {
            int length = 10;
            int[][] updates = new int[][]{new int[]{2, 4, 6}, new int[]{5, 6, 8}, new int[]{1, 9, -4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getModifiedArray(length, updates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,-4,2,2,2,4,4,-4,-4,-4]");
        System.out.println();
    }
}
