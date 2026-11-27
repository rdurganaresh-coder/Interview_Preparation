package com.leetcode.arrays_hashing_greedy;

class UnionFind2709 {
    private int[] p;
    private int[] size;

    public UnionFind2709(int n) {
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

class Solution2709 {
    private static final int MX = 100010;
    private static final List<Integer>[] P = new List[MX];

    static {
        Arrays.setAll(P, k -> new ArrayList<>());
        for (int x = 1; x < MX; ++x) {
            int v = x;
            int i = 2;
            while (i <= v / i) {
                if (v % i == 0) {
                    P[x].add(i);
                    while (v % i == 0) {
                        v /= i;
                    }
                }
                ++i;
            }
            if (v > 1) {
                P[x].add(v);
            }
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        UnionFind2709 uf = new UnionFind2709(n + m + 1);
        for (int i = 0; i < n; ++i) {
            for (int j : P[nums[i]]) {
                uf.union(i, j + n);
            }
        }
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            s.add(uf.find(i));
        }
        return s.size() == 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2709 _tcSol = new Solution2709();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,6]");
        try {
            int[] nums = new int[]{2, 3, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.canTraverseAllPairs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,9,5]");
        try {
            int[] nums = new int[]{3, 9, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.canTraverseAllPairs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [4,3,12,8]");
        try {
            int[] nums = new int[]{4, 3, 12, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.canTraverseAllPairs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}