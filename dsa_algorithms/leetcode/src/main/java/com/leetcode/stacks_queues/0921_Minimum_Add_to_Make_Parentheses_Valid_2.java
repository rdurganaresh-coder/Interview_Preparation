package com.leetcode.stacks_queues;

class Solution0921_2 {
    public int minAddToMakeValid(String s) {
        int ans = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++cnt;
            } else if (cnt > 0) {
                --cnt;
            } else {
                ++ans;
            }
        }
        ans += cnt;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0921_2 _tcSol = new Solution0921_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"())\"");
        try {
            String s = "())";
            System.out.println("  Output  : " + _tcShow(_tcSol.minAddToMakeValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"(((\"");
        try {
            String s = "(((";
            System.out.println("  Output  : " + _tcShow(_tcSol.minAddToMakeValid(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}