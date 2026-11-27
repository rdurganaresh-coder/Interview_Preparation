package com.leetcode.strings;

class Solution1221 {
    public int balancedStringSplit(String s) {
        int ans = 0, l = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                ++l;
            } else {
                --l;
            }
            if (l == 0) {
                ++ans;
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
        Solution1221 _tcSol = new Solution1221();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"RLRRLLRLRL\"");
        try {
            String s = "RLRRLLRLRL";
            System.out.println("  Output  : " + _tcShow(_tcSol.balancedStringSplit(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"RLRRRLLRLL\"");
        try {
            String s = "RLRRRLLRLL";
            System.out.println("  Output  : " + _tcShow(_tcSol.balancedStringSplit(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"LLLLRRRR\"");
        try {
            String s = "LLLLRRRR";
            System.out.println("  Output  : " + _tcShow(_tcSol.balancedStringSplit(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}