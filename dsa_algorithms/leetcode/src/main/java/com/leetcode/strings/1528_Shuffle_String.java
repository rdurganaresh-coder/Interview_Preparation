package com.leetcode.strings;

class Solution1528 {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] ans = new char[n];
        for (int i = 0; i < n; ++i) {
            ans[indices[i]] = s.charAt(i);
        }
        return new String(ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1528 _tcSol = new Solution1528();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"codeleet\", indices = [4,5,6,7,0,2,1,3]");
        try {
            String s = "codeleet";
            int[] indices = new int[]{4, 5, 6, 7, 0, 2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.restoreString(s, indices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"leetcode\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abc\", indices = [0,1,2]");
        try {
            String s = "abc";
            int[] indices = new int[]{0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.restoreString(s, indices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abc\"");
        System.out.println();
    }
}
