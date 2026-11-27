package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree1626_2 {
    private int n;
    private int[] c;

    public BinaryIndexedTree1626_2(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int val) {
        while (x <= n) {
            c[x] = Math.max(c[x], val);
            x += x & -x;
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s = Math.max(s, c[x]);
            x -= x & -x;
        }
        return s;
    }
}

class Solution1626_2 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {scores[i], ages[i]};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int m = 0;
        for (int age : ages) {
            m = Math.max(m, age);
        }
        BinaryIndexedTree1626_2 tree = new BinaryIndexedTree1626_2(m);
        for (int[] x : arr) {
            tree.update(x[1], x[0] + tree.query(x[1]));
        }
        return tree.query(m);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1626_2 _tcSol = new Solution1626_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "scores = [1,3,5,10,15], ages = [1,2,3,4,5]");
        try {
            int[] scores = new int[]{1, 3, 5, 10, 15};
            int[] ages = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.bestTeamScore(scores, ages)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "34");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "scores = [4,5,6,5], ages = [2,1,2,1]");
        try {
            int[] scores = new int[]{4, 5, 6, 5};
            int[] ages = new int[]{2, 1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.bestTeamScore(scores, ages)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "scores = [1,2,3,5], ages = [8,9,10,1]");
        try {
            int[] scores = new int[]{1, 2, 3, 5};
            int[] ages = new int[]{8, 9, 10, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.bestTeamScore(scores, ages)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}