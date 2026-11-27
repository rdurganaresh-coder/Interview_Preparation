package com.leetcode.arrays_hashing_greedy;

class Solution0544 {
    public String findContestMatch(int n) {
        String[] s = new String[n];
        for (int i = 0; i < n; ++i) {
            s[i] = String.valueOf(i + 1);
        }
        for (; n > 1; n >>= 1) {
            for (int i = 0; i < n >> 1; ++i) {
                s[i] = String.format("(%s,%s)", s[i], s[n - i - 1]);
            }
        }
        return s[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0544 _tcSol = new Solution0544();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4");
        try {
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findContestMatch(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"((1,4),(2,3))\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 8");
        try {
            int n = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.findContestMatch(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"(((1,8),(4,5)),((2,7),(3,6)))\"");
        System.out.println();
    }
}