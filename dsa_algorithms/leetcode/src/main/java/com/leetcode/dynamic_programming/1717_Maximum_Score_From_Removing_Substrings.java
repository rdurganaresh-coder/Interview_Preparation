package com.leetcode.dynamic_programming;

class Solution1717 {
    public int maximumGain(String s, int x, int y) {
        char a = 'a', b = 'b';
        if (x < y) {
            int t = x;
            x = y;
            y = t;
            char c = a;
            a = b;
            b = c;
        }
        int ans = 0, cnt1 = 0, cnt2 = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == a) {
                cnt1++;
            } else if (c == b) {
                if (cnt1 > 0) {
                    ans += x;
                    cnt1--;
                } else {
                    cnt2++;
                }
            } else {
                ans += Math.min(cnt1, cnt2) * y;
                cnt1 = 0;
                cnt2 = 0;
            }
        }
        ans += Math.min(cnt1, cnt2) * y;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1717 _tcSol = new Solution1717();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"cdbcbbaaabab\", x = 4, y = 5");
        try {
            String s = "cdbcbbaaabab";
            int x = 4;
            int y = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumGain(s, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aabbaaxybbaabb\", x = 5, y = 4");
        try {
            String s = "aabbaaxybbaabb";
            int x = 5;
            int y = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumGain(s, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}