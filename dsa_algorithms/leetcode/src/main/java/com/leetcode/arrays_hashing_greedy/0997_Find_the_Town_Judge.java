package com.leetcode.arrays_hashing_greedy;

class Solution0997 {
    public int findJudge(int n, int[][] trust) {
        int[] cnt1 = new int[n + 1];
        int[] cnt2 = new int[n + 1];
        for (var t : trust) {
            int a = t[0], b = t[1];
            ++cnt1[a];
            ++cnt2[b];
        }
        for (int i = 1; i <= n; ++i) {
            if (cnt1[i] == 0 && cnt2[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0997 _tcSol = new Solution0997();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, trust = [[1,2]]");
        try {
            int n = 2;
            int[][] trust = new int[][]{new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findJudge(n, trust)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, trust = [[1,3],[2,3]]");
        try {
            int n = 3;
            int[][] trust = new int[][]{new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findJudge(n, trust)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, trust = [[1,3],[2,3],[3,1]]");
        try {
            int n = 3;
            int[][] trust = new int[][]{new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findJudge(n, trust)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}