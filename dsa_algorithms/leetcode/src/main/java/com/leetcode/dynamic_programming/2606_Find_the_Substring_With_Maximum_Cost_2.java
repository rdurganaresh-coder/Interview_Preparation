package com.leetcode.dynamic_programming;

class Solution2606_2 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] d = new int[26];
        for (int i = 0; i < d.length; ++i) {
            d[i] = i + 1;
        }
        int m = chars.length();
        for (int i = 0; i < m; ++i) {
            d[chars.charAt(i) - 'a'] = vals[i];
        }
        int ans = 0, f = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int v = d[s.charAt(i) - 'a'];
            f = Math.max(f, 0) + v;
            ans = Math.max(ans, f);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2606_2 _tcSol = new Solution2606_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"adaa\", chars = \"d\", vals = [-1000]");
        try {
            String s = "adaa";
            String chars = "d";
            int[] vals = new int[]{-1000};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCostSubstring(s, chars, vals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abc\", chars = \"abc\", vals = [-1,-1,-1]");
        try {
            String s = "abc";
            String chars = "abc";
            int[] vals = new int[]{-1, -1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCostSubstring(s, chars, vals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}