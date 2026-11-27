package com.leetcode.backtracking;

class Solution3146 {
    public int findPermutationDifference(String s, String t) {
        int[] d = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            d[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.abs(d[t.charAt(i) - 'a'] - i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3146 _tcSol = new Solution3146();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abc\", t = \"bac\"");
        try {
            String s = "abc";
            String t = "bac";
            System.out.println("  Output  : " + _tcShow(_tcSol.findPermutationDifference(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcde\", t = \"edbac\"");
        try {
            String s = "abcde";
            String t = "edbac";
            System.out.println("  Output  : " + _tcShow(_tcSol.findPermutationDifference(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}