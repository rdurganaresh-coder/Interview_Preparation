package com.leetcode.arrays_hashing_greedy;

class Solution0455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length;
        int n = s.length;
        for (int i = 0, j = 0; i < m; ++i) {
            while (j < n && s[j] < g[i]) {
                ++j;
            }
            if (j++ >= n) {
                return i;
            }
        }
        return m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0455 _tcSol = new Solution0455();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "g = [1,2,3], s = [1,1]");
        try {
            int[] g = new int[]{1, 2, 3};
            int[] s = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findContentChildren(g, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "g = [1,2], s = [1,2,3]");
        try {
            int[] g = new int[]{1, 2};
            int[] s = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findContentChildren(g, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}