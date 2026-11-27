package com.leetcode.arrays_hashing_greedy;

class Solution3445 {
    public int maxDifference(String S, int k) {
        char[] s = S.toCharArray();
        int n = s.length;
        final int inf = Integer.MAX_VALUE / 2;
        int ans = -inf;
        for (int a = 0; a < 5; ++a) {
            for (int b = 0; b < 5; ++b) {
                if (a == b) {
                    continue;
                }
                int curA = 0, curB = 0;
                int preA = 0, preB = 0;
                int[][] t = {{inf, inf}, {inf, inf}};
                for (int l = -1, r = 0; r < n; ++r) {
                    curA += s[r] == '0' + a ? 1 : 0;
                    curB += s[r] == '0' + b ? 1 : 0;
                    while (r - l >= k && curB - preB >= 2) {
                        t[preA & 1][preB & 1] = Math.min(t[preA & 1][preB & 1], preA - preB);
                        ++l;
                        preA += s[l] == '0' + a ? 1 : 0;
                        preB += s[l] == '0' + b ? 1 : 0;
                    }
                    ans = Math.max(ans, curA - curB - t[curA & 1 ^ 1][curB & 1]);
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
        Solution3445 _tcSol = new Solution3445();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"12233\", k = 4");
        try {
            String S = "12233";
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDifference(S, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"1122211\", k = 3");
        try {
            String S = "1122211";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDifference(S, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"110\", k = 3");
        try {
            String S = "110";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDifference(S, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}