package com.leetcode.arrays_hashing_greedy;

class Solution0753 {
    private Set<Integer> vis = new HashSet<>();
    private StringBuilder ans = new StringBuilder();
    private int mod;

    public String crackSafe(int n, int k) {
        mod = (int) Math.pow(10, n - 1);
        dfs(0, k);
        ans.append("0".repeat(n - 1));
        return ans.toString();
    }

    private void dfs(int u, int k) {
        for (int x = 0; x < k; ++x) {
            int e = u * 10 + x;
            if (vis.add(e)) {
                int v = e % mod;
                dfs(v, k);
                ans.append(x);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0753 _tcSol = new Solution0753();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1, k = 2");
        try {
            int n = 1;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.crackSafe(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"10\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, k = 2");
        try {
            int n = 2;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.crackSafe(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"01100\"");
        System.out.println();
    }
}