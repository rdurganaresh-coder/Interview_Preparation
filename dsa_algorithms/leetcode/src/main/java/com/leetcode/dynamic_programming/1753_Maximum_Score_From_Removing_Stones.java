package com.leetcode.dynamic_programming;

class Solution1753 {
    public int maximumScore(int a, int b, int c) {
        int[] s = new int[] {a, b, c};
        Arrays.sort(s);
        int ans = 0;
        while (s[1] > 0) {
            ++ans;
            s[1]--;
            s[2]--;
            Arrays.sort(s);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1753 _tcSol = new Solution1753();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 2, b = 4, c = 6");
        try {
            int a = 2;
            int b = 4;
            int c = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScore(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 4, b = 4, c = 6");
        try {
            int a = 4;
            int b = 4;
            int c = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScore(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "a = 1, b = 8, c = 8");
        try {
            int a = 1;
            int b = 8;
            int c = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumScore(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}