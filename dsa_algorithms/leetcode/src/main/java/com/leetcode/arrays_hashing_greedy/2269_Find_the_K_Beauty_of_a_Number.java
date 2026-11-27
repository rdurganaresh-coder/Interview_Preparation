package com.leetcode.arrays_hashing_greedy;

class Solution2269 {
    public int divisorSubstrings(int num, int k) {
        int ans = 0;
        String s = "" + num;
        for (int i = 0; i < s.length() - k + 1; ++i) {
            int t = Integer.parseInt(s.substring(i, i + k));
            if (t != 0 && num % t == 0) {
                ++ans;
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
        Solution2269 _tcSol = new Solution2269();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 240, k = 2");
        try {
            int num = 240;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisorSubstrings(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 430043, k = 2");
        try {
            int num = 430043;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisorSubstrings(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}