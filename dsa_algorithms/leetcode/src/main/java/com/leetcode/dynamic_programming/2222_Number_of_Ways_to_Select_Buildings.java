package com.leetcode.dynamic_programming;

class Solution2222 {
    public long numberOfWays(String s) {
        int n = s.length();
        int[] l = new int[2];
        int[] r = new int[2];
        for (int i = 0; i < n; ++i) {
            r[s.charAt(i) - '0']++;
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = s.charAt(i) - '0';
            r[x]--;
            ans += 1L * l[x ^ 1] * r[x ^ 1];
            l[x]++;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2222 _tcSol = new Solution2222();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"001101\"");
        try {
            String s = "001101";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"11100\"");
        try {
            String s = "11100";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
