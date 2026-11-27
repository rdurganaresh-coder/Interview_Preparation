package com.leetcode.arrays_hashing_greedy;

class UnionFind0947_2 {
    private final int[] p;
    private final int[] size;

    public UnionFind0947_2(int n) {
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) {
            return false;
        }
        if (size[pa] > size[pb]) {
            p[pb] = pa;
            size[pa] += size[pb];
        } else {
            p[pa] = pb;
            size[pb] += size[pa];
        }
        return true;
    }
}

class Solution0947_2 {
    public int removeStones(int[][] stones) {
        int m = 10001;
        UnionFind0947_2 uf = new UnionFind0947_2(m << 1);
        for (var st : stones) {
            uf.union(st[0], st[1] + m);
        }
        Set<Integer> s = new HashSet<>();
        for (var st : stones) {
            s.add(uf.find(st[0]));
        }
        return stones.length - s.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0947_2 _tcSol = new Solution0947_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]");
        try {
            int[][] stones = new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 0}, new int[]{1, 2}, new int[]{2, 1}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeStones(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]");
        try {
            int[][] stones = new int[][]{new int[]{0, 0}, new int[]{0, 2}, new int[]{1, 1}, new int[]{2, 0}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeStones(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "stones = [[0,0]]");
        try {
            int[][] stones = new int[][]{new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeStones(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}