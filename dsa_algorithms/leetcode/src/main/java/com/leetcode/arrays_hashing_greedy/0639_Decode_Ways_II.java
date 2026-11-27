package com.leetcode.arrays_hashing_greedy;

class Solution0639 {

    private static final int MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();

        // dp[i - 2], dp[i - 1], dp[i]
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++) {
            // 1 digit
            if (cs[i - 1] == '*') {
                c = 9 * b % MOD;
            } else if (cs[i - 1] != '0') {
                c = b;
            } else {
                c = 0;
            }

            // 2 digits
            if (i > 1) {
                if (cs[i - 2] == '*' && cs[i - 1] == '*') {
                    c = (c + 15 * a) % MOD;
                } else if (cs[i - 2] == '*') {
                    if (cs[i - 1] > '6') {
                        c = (c + a) % MOD;
                    } else {
                        c = (c + 2 * a) % MOD;
                    }
                } else if (cs[i - 1] == '*') {
                    if (cs[i - 2] == '1') {
                        c = (c + 9 * a) % MOD;
                    } else if (cs[i - 2] == '2') {
                        c = (c + 6 * a) % MOD;
                    }
                } else if (cs[i - 2] != '0' && (cs[i - 2] - '0') * 10 + cs[i - 1] - '0' <= 26) {
                    c = (c + a) % MOD;
                }
            }

            a = b;
            b = c;
        }

        return (int) c;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0639 _tcSol = new Solution0639();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"*\"");
        try {
            String s = "*";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDecodings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"1*\"");
        try {
            String s = "1*";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDecodings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"2*\"");
        try {
            String s = "2*";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDecodings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}