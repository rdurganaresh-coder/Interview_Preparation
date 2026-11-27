package com.leetcode.graphs_shortest_path;

class Solution0821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        final int inf = 1 << 30;
        Arrays.fill(ans, inf);
        for (int i = 0, pre = -inf; i < n; ++i) {
            if (s.charAt(i) == c) {
                pre = i;
            }
            ans[i] = Math.min(ans[i], i - pre);
        }
        for (int i = n - 1, suf = inf; i >= 0; --i) {
            if (s.charAt(i) == c) {
                suf = i;
            }
            ans[i] = Math.min(ans[i], suf - i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0821 _tcSol = new Solution0821();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"loveleetcode\", c = \"e\"");
        try {
            String s = "loveleetcode";
            char c = 'e';
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestToChar(s, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,1,0,1,0,0,1,2,2,1,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaab\", c = \"b\"");
        try {
            String s = "aaab";
            char c = 'b';
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestToChar(s, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,1,0]");
        System.out.println();
    }
}