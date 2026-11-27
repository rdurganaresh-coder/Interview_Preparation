package com.leetcode.arrays_hashing_greedy;

class Solution0670 {
    public int maximumSwap(int num) {
        char[] s = String.valueOf(num).toCharArray();
        int n = s.length;
        int[] d = new int[n];
        for (int i = 0; i < n; ++i) {
            d[i] = i;
        }
        for (int i = n - 2; i >= 0; --i) {
            if (s[i] <= s[d[i + 1]]) {
                d[i] = d[i + 1];
            }
        }
        for (int i = 0; i < n; ++i) {
            int j = d[i];
            if (s[i] < s[j]) {
                char t = s[i];
                s[i] = s[j];
                s[j] = t;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(s));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0670 _tcSol = new Solution0670();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 2736");
        try {
            int num = 2736;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSwap(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7236");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 9973");
        try {
            int num = 9973;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSwap(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9973");
        System.out.println();
    }
}