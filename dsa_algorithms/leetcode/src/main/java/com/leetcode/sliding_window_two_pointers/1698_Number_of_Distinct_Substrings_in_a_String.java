package com.leetcode.sliding_window_two_pointers;

class Solution1698 {
    public int countDistinct(String s) {
        Set<String> ss = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                ss.add(s.substring(i, j));
            }
        }
        return ss.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1698 _tcSol = new Solution1698();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aabbaba\"");
        try {
            String s = "aabbaba";
            System.out.println("  Output  : " + _tcShow(_tcSol.countDistinct(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcdefg\"");
        try {
            String s = "abcdefg";
            System.out.println("  Output  : " + _tcShow(_tcSol.countDistinct(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();
    }
}