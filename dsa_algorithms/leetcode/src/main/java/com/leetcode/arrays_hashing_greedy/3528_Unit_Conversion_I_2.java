package com.leetcode.arrays_hashing_greedy;

class Solution3528_2 {
    public int[] baseUnitConversions(int[][] conversions) {
        final int mod = (int) 1e9 + 7;
        int n = conversions.length + 1;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : conversions) {
            g[e[0]].add(new int[] {e[1], e[2]});
        }
        int[] ans = new int[n];
        Deque<long[]> stk = new ArrayDeque<>();
        stk.push(new long[] {0, 1});
        while (!stk.isEmpty()) {
            long[] cur = stk.pop();
            int s = (int) cur[0];
            long mul = cur[1];
            ans[s] = (int) mul;
            for (var e : g[s]) {
                stk.push(new long[] {e[0], mul * e[1] % mod});
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3528_2 _tcSol = new Solution3528_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "conversions = [[0,1,2],[1,2,3]]");
        try {
            int[][] conversions = new int[][]{new int[]{0, 1, 2}, new int[]{1, 2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.baseUnitConversions(conversions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "conversions = [[0,1,2],[0,2,3],[1,3,4],[1,4,5],[2,5,2],[4,6,3],[5,7,4]]");
        try {
            int[][] conversions = new int[][]{new int[]{0, 1, 2}, new int[]{0, 2, 3}, new int[]{1, 3, 4}, new int[]{1, 4, 5}, new int[]{2, 5, 2}, new int[]{4, 6, 3}, new int[]{5, 7, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.baseUnitConversions(conversions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,8,10,6,30,24]");
        System.out.println();
    }
}
