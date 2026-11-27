package com.leetcode.strings;

class Solution0859 {
    public boolean buddyStrings(String s, String goal) {
        int m = s.length(), n = goal.length();
        if (m != n) {
            return false;
        }
        int diff = 0;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            int a = s.charAt(i), b = goal.charAt(i);
            ++cnt1[a - 'a'];
            ++cnt2[b - 'a'];
            if (a != b) {
                ++diff;
            }
        }
        boolean f = false;
        for (int i = 0; i < 26; ++i) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
            if (cnt1[i] > 1) {
                f = true;
            }
        }
        return diff == 2 || (diff == 0 && f);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0859 _tcSol = new Solution0859();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ab\", goal = \"ba\"");
        try {
            String s = "ab";
            String goal = "ba";
            System.out.println("  Output  : " + _tcShow(_tcSol.buddyStrings(s, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"ab\", goal = \"ab\"");
        try {
            String s = "ab";
            String goal = "ab";
            System.out.println("  Output  : " + _tcShow(_tcSol.buddyStrings(s, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"aa\", goal = \"aa\"");
        try {
            String s = "aa";
            String goal = "aa";
            System.out.println("  Output  : " + _tcShow(_tcSol.buddyStrings(s, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}