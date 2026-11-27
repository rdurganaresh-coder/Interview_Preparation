package com.leetcode.dynamic_programming;

class Solution2374 {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] cnt = new long[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int j = edges[i];
            cnt[j] += i;
            if (cnt[ans] < cnt[j] || (cnt[ans] == cnt[j] && j < ans)) {
                ans = j;
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
        Solution2374 _tcSol = new Solution2374();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [1,0,0,0,0,7,7,5]");
        try {
            int[] edges = new int[]{1, 0, 0, 0, 0, 7, 7, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.edgeScore(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [2,0,0,2]");
        try {
            int[] edges = new int[]{2, 0, 0, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.edgeScore(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
