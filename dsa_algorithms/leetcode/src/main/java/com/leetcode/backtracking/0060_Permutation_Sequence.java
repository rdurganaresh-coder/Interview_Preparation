package com.leetcode.backtracking;

class Solution0060 {
    public String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        boolean[] vis = new boolean[n + 1];
        for (int i = 0; i < n; ++i) {
            int fact = 1;
            for (int j = 1; j < n - i; ++j) {
                fact *= j;
            }
            for (int j = 1; j <= n; ++j) {
                if (!vis[j]) {
                    if (k > fact) {
                        k -= fact;
                    } else {
                        ans.append(j);
                        vis[j] = true;
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0060 _tcSol = new Solution0060();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 3");
        try {
            int n = 3;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getPermutation(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"213\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, k = 9");
        try {
            int n = 4;
            int k = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.getPermutation(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2314\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, k = 1");
        try {
            int n = 3;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.getPermutation(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"123\"");
        System.out.println();
    }
}