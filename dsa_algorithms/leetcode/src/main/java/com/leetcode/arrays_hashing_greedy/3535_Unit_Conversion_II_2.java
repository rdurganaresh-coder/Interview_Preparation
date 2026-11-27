package com.leetcode.arrays_hashing_greedy;

class Solution3535_2 {
    private final int mod = (int) 1e9 + 7;

    public int[] queryConversions(int[][] conversions, int[][] queries) {
        int n = conversions.length + 1;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : conversions) {
            g[e[0]].add(new int[] {e[1], e[2]});
        }
        int[] res = new int[n];
        Deque<long[]> stk = new ArrayDeque<>();
        stk.push(new long[] {0, 1});
        while (!stk.isEmpty()) {
            long[] cur = stk.pop();
            int s = (int) cur[0];
            long mul = cur[1];
            res[s] = (int) mul;
            for (var e : g[s]) {
                stk.push(new long[] {e[0], mul * e[1] % mod});
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            ans[i] = (int) ((long) res[y] * qpow(res[x], mod - 2) % mod);
        }
        return ans;
    }

    private long qpow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3535_2 _tcSol = new Solution3535_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "conversions = [[0,1,2],[0,2,6]], queries = [[1,2],[1,0]]");
        try {
            int[][] conversions = new int[][]{new int[]{0, 1, 2}, new int[]{0, 2, 6}};
            int[][] queries = new int[][]{new int[]{1, 2}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.queryConversions(conversions, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,500000004]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "conversions = [[0,1,2],[0,2,6],[0,3,8],[2,4,2],[2,5,4],[3,6,3]], queries = [[1,2],[0,4],[6,5],[4,6],[6,1]]");
        try {
            int[][] conversions = new int[][]{new int[]{0, 1, 2}, new int[]{0, 2, 6}, new int[]{0, 3, 8}, new int[]{2, 4, 2}, new int[]{2, 5, 4}, new int[]{3, 6, 3}};
            int[][] queries = new int[][]{new int[]{1, 2}, new int[]{0, 4}, new int[]{6, 5}, new int[]{4, 6}, new int[]{6, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.queryConversions(conversions, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,12,1,2,83333334]");
        System.out.println();
    }
}
