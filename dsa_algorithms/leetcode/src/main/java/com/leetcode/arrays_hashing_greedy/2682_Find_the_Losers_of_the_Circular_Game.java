package com.leetcode.arrays_hashing_greedy;

class Solution2682 {
    public int[] circularGameLosers(int n, int k) {
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for (int i = 0, p = 1; !vis[i]; ++p) {
            vis[i] = true;
            ++cnt;
            i = (i + p * k) % n;
        }
        int[] ans = new int[n - cnt];
        for (int i = 0, j = 0; i < n; ++i) {
            if (!vis[i]) {
                ans[j++] = i + 1;
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
        Solution2682 _tcSol = new Solution2682();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, k = 2");
        try {
            int n = 5;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.circularGameLosers(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, k = 4");
        try {
            int n = 4;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.circularGameLosers(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,4]");
        System.out.println();
    }
}