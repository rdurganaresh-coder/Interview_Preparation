package com.leetcode.dynamic_programming;

class Solution2712 {
    public long minimumCost(String s) {
        long ans = 0;
        int n = s.length();
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans += Math.min(i, n - i);
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
        Solution2712 _tcSol = new Solution2712();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"0011\"");
        try {
            String s = "0011";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"010101\"");
        try {
            String s = "010101";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}