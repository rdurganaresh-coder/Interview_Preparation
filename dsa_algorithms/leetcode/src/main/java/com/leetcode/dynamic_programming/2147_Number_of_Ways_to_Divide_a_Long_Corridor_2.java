package com.leetcode.dynamic_programming;

class Solution2147_2 {
    public int numberOfWays(String corridor) {
        final int mod = (int) 1e9 + 7;
        long ans = 1, cnt = 0, last = 0;
        for (int i = 0; i < corridor.length(); ++i) {
            if (corridor.charAt(i) == 'S') {
                if (++cnt > 2 && cnt % 2 == 1) {
                    ans = ans * (i - last) % mod;
                }
                last = i;
            }
        }
        return cnt > 0 && cnt % 2 == 0 ? (int) ans : 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2147_2 _tcSol = new Solution2147_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "corridor = \"SSPPSPS\"");
        try {
            String corridor = "SSPPSPS";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(corridor)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "corridor = \"PPSPSP\"");
        try {
            String corridor = "PPSPSP";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(corridor)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "corridor = \"S\"");
        try {
            String corridor = "S";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(corridor)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
