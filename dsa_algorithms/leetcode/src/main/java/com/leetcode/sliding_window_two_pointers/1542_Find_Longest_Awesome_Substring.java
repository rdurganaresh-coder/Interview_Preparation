package com.leetcode.sliding_window_two_pointers;

class Solution1542 {
    public int longestAwesome(String s) {
        int[] d = new int[1024];
        int st = 0, ans = 1;
        Arrays.fill(d, -1);
        d[0] = 0;
        for (int i = 1; i <= s.length(); ++i) {
            int v = s.charAt(i - 1) - '0';
            st ^= 1 << v;
            if (d[st] >= 0) {
                ans = Math.max(ans, i - d[st]);
            } else {
                d[st] = i;
            }
            for (v = 0; v < 10; ++v) {
                if (d[st ^ (1 << v)] >= 0) {
                    ans = Math.max(ans, i - d[st ^ (1 << v)]);
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
        Solution1542 _tcSol = new Solution1542();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"3242415\"");
        try {
            String s = "3242415";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestAwesome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"12345678\"");
        try {
            String s = "12345678";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestAwesome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"213123\"");
        try {
            String s = "213123";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestAwesome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}