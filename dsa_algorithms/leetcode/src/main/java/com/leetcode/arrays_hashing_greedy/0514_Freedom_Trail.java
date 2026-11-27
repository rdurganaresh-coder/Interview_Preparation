package com.leetcode.arrays_hashing_greedy;

class Solution0514 {
    public int findRotateSteps(String ring, String key) {
        int m = key.length(), n = ring.length();
        List<Integer>[] pos = new List[26];
        Arrays.setAll(pos, k -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            int j = ring.charAt(i) - 'a';
            pos[j].add(i);
        }
        int[][] f = new int[m][n];
        for (var g : f) {
            Arrays.fill(g, 1 << 30);
        }
        for (int j : pos[key.charAt(0) - 'a']) {
            f[0][j] = Math.min(j, n - j) + 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    f[i][j] = Math.min(
                        f[i][j], f[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        int ans = 1 << 30;
        for (int j : pos[key.charAt(m - 1) - 'a']) {
            ans = Math.min(ans, f[m - 1][j]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0514 _tcSol = new Solution0514();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ring = \"godding\", key = \"gd\"");
        try {
            String ring = "godding";
            String key = "gd";
            System.out.println("  Output  : " + _tcShow(_tcSol.findRotateSteps(ring, key)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ring = \"godding\", key = \"godding\"");
        try {
            String ring = "godding";
            String key = "godding";
            System.out.println("  Output  : " + _tcShow(_tcSol.findRotateSteps(ring, key)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}