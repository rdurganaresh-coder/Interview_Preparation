package com.leetcode.bit_manipulation_math;

class Solution2847 {
    public String smallestNumber(long n) {
        int[] cnt = new int[10];
        for (int i = 9; i > 1; --i) {
            while (n % i == 0) {
                ++cnt[i];
                n /= i;
            }
        }
        if (n > 1) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < 10; ++i) {
            while (cnt[i] > 0) {
                sb.append(i);
                --cnt[i];
            }
        }
        String ans = sb.toString();
        return ans.isEmpty() ? "1" : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2847 _tcSol = new Solution2847();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 105");
        try {
            long n = 105L;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"357\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7");
        try {
            long n = 7L;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"7\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 44");
        try {
            long n = 44L;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"-1\"");
        System.out.println();
    }
}