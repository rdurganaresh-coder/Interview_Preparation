package com.leetcode.strings;

class UnionFind0839 {
    private final int[] p;
    private final int[] size;

    public UnionFind0839(int n) {
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

class Solution0839 {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length, m = strs[0].length();
        UnionFind0839 uf = new UnionFind0839(n);
        int cnt = n;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int diff = 0;
                for (int k = 0; k < m; ++k) {
                    if (strs[i].charAt(k) != strs[j].charAt(k)) {
                        ++diff;
                    }
                }
                if (diff <= 2 && uf.union(i, j)) {
                    --cnt;
                }
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0839 _tcSol = new Solution0839();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strs = [\"tars\",\"rats\",\"arts\",\"star\"]");
        try {
            String[] strs = new String[]{"tars", "rats", "arts", "star"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numSimilarGroups(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strs = [\"omv\",\"ovm\"]");
        try {
            String[] strs = new String[]{"omv", "ovm"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numSimilarGroups(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
