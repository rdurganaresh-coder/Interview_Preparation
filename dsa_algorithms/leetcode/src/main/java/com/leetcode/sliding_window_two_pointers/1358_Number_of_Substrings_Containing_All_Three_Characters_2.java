package com.leetcode.sliding_window_two_pointers;

class Solution1358_2 {
    public int numberOfSubstrings(String s) {
        int ans = 0, l = 0;
        int[] cnt = new int[3];
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            cnt[c - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[s.charAt(l) - 'a']--;
                l++;
            }
            ans += l;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1358_2 _tcSol = new Solution1358_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcabc\"");
        try {
            String s = "abcabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaacb\"");
        try {
            String s = "aaacb";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"abc\"");
        try {
            String s = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}