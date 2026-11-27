package com.leetcode.sliding_window_two_pointers;

class Solution0696 {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int i = 0;
        int pre = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int cur = j - i;
            ans += Math.min(pre, cur);
            pre = cur;
            i = j;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0696 _tcSol = new Solution0696();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"00110011\"");
        try {
            String s = "00110011";
            System.out.println("  Output  : " + _tcShow(_tcSol.countBinarySubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"10101\"");
        try {
            String s = "10101";
            System.out.println("  Output  : " + _tcShow(_tcSol.countBinarySubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
