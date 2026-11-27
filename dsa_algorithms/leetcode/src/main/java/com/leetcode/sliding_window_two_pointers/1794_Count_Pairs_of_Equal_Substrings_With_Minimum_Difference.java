package com.leetcode.sliding_window_two_pointers;

class Solution1794 {
    public int countQuadruples(String firstString, String secondString) {
        int[] last = new int[26];
        for (int i = 0; i < secondString.length(); ++i) {
            last[secondString.charAt(i) - 'a'] = i + 1;
        }
        int ans = 0, mi = 1 << 30;
        for (int i = 0; i < firstString.length(); ++i) {
            int j = last[firstString.charAt(i) - 'a'];
            if (j > 0) {
                int t = i - j;
                if (mi > t) {
                    mi = t;
                    ans = 1;
                } else if (mi == t) {
                    ++ans;
                }
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
        Solution1794 _tcSol = new Solution1794();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "firstString = \"abcd\", secondString = \"bccda\"");
        try {
            String firstString = "abcd";
            String secondString = "bccda";
            System.out.println("  Output  : " + _tcShow(_tcSol.countQuadruples(firstString, secondString)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "firstString = \"ab\", secondString = \"cd\"");
        try {
            String firstString = "ab";
            String secondString = "cd";
            System.out.println("  Output  : " + _tcShow(_tcSol.countQuadruples(firstString, secondString)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}