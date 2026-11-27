package com.leetcode.strings;

class Solution3307 {
    public char kthCharacter(long k, int[] operations) {
        long n = 1;
        int i = 0;
        while (n < k) {
            n *= 2;
            ++i;
        }
        int d = 0;
        while (n > 1) {
            if (k > n / 2) {
                k -= n / 2;
                d += operations[i - 1];
            }
            n /= 2;
            --i;
        }
        return (char) ('a' + (d % 26));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3307 _tcSol = new Solution3307();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 5, operations = [0,0,0]");
        try {
            long k = 5L;
            int[] operations = new int[]{0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.kthCharacter(k, operations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 10, operations = [0,1,0,1]");
        try {
            long k = 10L;
            int[] operations = new int[]{0, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.kthCharacter(k, operations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"b\"");
        System.out.println();
    }
}
