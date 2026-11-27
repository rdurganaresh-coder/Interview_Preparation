package com.leetcode.dynamic_programming;

class Solution1573 {
    private String s;

    public int numWays(String s) {
        this.s = s;
        int cnt = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') {
                ++cnt;
            }
        }
        int m = cnt % 3;
        if (m != 0) {
            return 0;
        }
        final int mod = (int) 1e9 + 7;
        if (cnt == 0) {
            return (int) (((n - 1L) * (n - 2) / 2) % mod);
        }
        cnt /= 3;
        long i1 = find(cnt), i2 = find(cnt + 1);
        long j1 = find(cnt * 2), j2 = find(cnt * 2 + 1);
        return (int) ((i2 - i1) * (j2 - j1) % mod);
    }

    private int find(int x) {
        int t = 0;
        for (int i = 0;; ++i) {
            t += s.charAt(i) == '1' ? 1 : 0;
            if (t == x) {
                return i;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1573 _tcSol = new Solution1573();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"10101\"");
        try {
            String s = "10101";
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"1001\"");
        try {
            String s = "1001";
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"0000\"");
        try {
            String s = "0000";
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}