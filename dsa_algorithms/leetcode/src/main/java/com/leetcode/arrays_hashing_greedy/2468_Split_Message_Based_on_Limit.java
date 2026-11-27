package com.leetcode.arrays_hashing_greedy;

class Solution2468 {
    public String[] splitMessage(String message, int limit) {
        int n = message.length();
        int sa = 0;
        String[] ans = new String[0];
        for (int k = 1; k <= n; ++k) {
            int lk = (k + "").length();
            sa += lk;
            int sb = lk * k;
            int sc = 3 * k;
            if (limit * k - (sa + sb + sc) >= n) {
                int i = 0;
                ans = new String[k];
                for (int j = 1; j <= k; ++j) {
                    String tail = String.format("<%d/%d>", j, k);
                    String t = message.substring(i, Math.min(n, i + limit - tail.length())) + tail;
                    ans[j - 1] = t;
                    i += limit - tail.length();
                }
                break;
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
        Solution2468 _tcSol = new Solution2468();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "message = \"this is really a very awesome message\", limit = 9");
        try {
            String message = "this is really a very awesome message";
            int limit = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.splitMessage(message, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"thi<1/14>\",\"s i<2/14>\",\"s r<3/14>\",\"eal<4/14>\",\"ly <5/14>\",\"a v<6/14>\",\"ery<7/14>\",\" aw<8/14>\",\"eso<9/14>\",\"me<10/14>\",\" m<11/14>\",\"es<12/14>\",\"sa<13/14>\",\"ge<14/14>\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "message = \"short message\", limit = 15");
        try {
            String message = "short message";
            int limit = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.splitMessage(message, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"short mess<1/2>\",\"age<2/2>\"]");
        System.out.println();
    }
}