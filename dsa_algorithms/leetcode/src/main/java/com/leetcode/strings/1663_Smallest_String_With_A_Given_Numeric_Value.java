package com.leetcode.strings;

class Solution1663 {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        int i = n - 1, d = k - n;
        for (; d > 25; d -= 25) {
            ans[i--] = 'z';
        }
        ans[i] = (char) ('a' + d);
        return String.valueOf(ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1663 _tcSol = new Solution1663();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, k = 27");
        try {
            int n = 3;
            int k = 27;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSmallestString(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aay\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, k = 73");
        try {
            int n = 5;
            int k = 73;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSmallestString(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaszz\"");
        System.out.println();
    }
}