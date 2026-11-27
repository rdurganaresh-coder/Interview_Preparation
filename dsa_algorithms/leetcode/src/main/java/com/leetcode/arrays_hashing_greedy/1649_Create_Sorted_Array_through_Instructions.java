package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree1649 {
    private int n;
    private int[] c;

    public BinaryIndexedTree1649(int n) {
        this.n = n;
        this.c = new int[n + 1];
    }

    public void update(int x, int v) {
        while (x <= n) {
            c[x] += v;
            x += x & -x;
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= x & -x;
        }
        return s;
    }
}

class Solution1649 {
    public int createSortedArray(int[] instructions) {
        int m = 0;
        for (int x : instructions) {
            m = Math.max(m, x);
        }
        BinaryIndexedTree1649 tree = new BinaryIndexedTree1649(m);
        int ans = 0;
        final int mod = (int) 1e9 + 7;
        for (int i = 0; i < instructions.length; ++i) {
            int x = instructions[i];
            int cost = Math.min(tree.query(x - 1), i - tree.query(x));
            ans = (ans + cost) % mod;
            tree.update(x, 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1649 _tcSol = new Solution1649();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "instructions = [1,5,6,2]");
        try {
            int[] instructions = new int[]{1, 5, 6, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.createSortedArray(instructions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "instructions = [1,2,3,6,5,4]");
        try {
            int[] instructions = new int[]{1, 2, 3, 6, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.createSortedArray(instructions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "instructions = [1,3,3,3,2,4,2,1,2]");
        try {
            int[] instructions = new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.createSortedArray(instructions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}