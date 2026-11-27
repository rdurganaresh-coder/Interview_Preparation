package com.leetcode.arrays_hashing_greedy;

class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] cnt = new int[100];
        int ans = 0;
        for (var e : dominoes) {
            int x = e[0] < e[1] ? e[0] * 10 + e[1] : e[1] * 10 + e[0];
            ans += cnt[x]++;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1128 _tcSol = new Solution1128();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "dominoes = [[1,2],[2,1],[3,4],[5,6]]");
        try {
            int[][] dominoes = new int[][]{new int[]{1, 2}, new int[]{2, 1}, new int[]{3, 4}, new int[]{5, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numEquivDominoPairs(dominoes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]");
        try {
            int[][] dominoes = new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 1}, new int[]{1, 2}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numEquivDominoPairs(dominoes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}