package com.leetcode.arrays_hashing_greedy;

class Solution3237 {
    public int[] simulationResult(int[] windows, int[] queries) {
        int n = windows.length;
        boolean[] s = new boolean[n + 1];
        int[] ans = new int[n];
        int k = 0;
        for (int i = queries.length - 1; i >= 0; --i) {
            int q = queries[i];
            if (!s[q]) {
                ans[k++] = q;
                s[q] = true;
            }
        }
        for (int w : windows) {
            if (!s[w]) {
                ans[k++] = w;
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
        Solution3237 _tcSol = new Solution3237();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "windows = [1,2,3], queries = [3,3,2]");
        try {
            int[] windows = new int[]{1, 2, 3};
            int[] queries = new int[]{3, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.simulationResult(windows, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "windows = [1,4,2,3], queries = [4,1,3]");
        try {
            int[] windows = new int[]{1, 4, 2, 3};
            int[] queries = new int[]{4, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.simulationResult(windows, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,4,2]");
        System.out.println();
    }
}
