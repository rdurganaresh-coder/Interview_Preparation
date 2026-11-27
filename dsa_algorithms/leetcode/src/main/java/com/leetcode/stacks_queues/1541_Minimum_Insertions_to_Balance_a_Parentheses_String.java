package com.leetcode.stacks_queues;

class Solution1541 {
    public int minInsertions(String s) {
        int ans = 0, x = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                ++x;
            } else {
                if (i < n - 1 && s.charAt(i + 1) == ')') {
                    ++i;
                } else {
                    ++ans;
                }
                if (x == 0) {
                    ++ans;
                } else {
                    --x;
                }
            }
        }
        ans += x << 1;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1541 _tcSol = new Solution1541();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"(()))\"");
        try {
            String s = "(()))";
            System.out.println("  Output  : " + _tcShow(_tcSol.minInsertions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"())\"");
        try {
            String s = "())";
            System.out.println("  Output  : " + _tcShow(_tcSol.minInsertions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"))())(\"");
        try {
            String s = "))())(";
            System.out.println("  Output  : " + _tcShow(_tcSol.minInsertions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}