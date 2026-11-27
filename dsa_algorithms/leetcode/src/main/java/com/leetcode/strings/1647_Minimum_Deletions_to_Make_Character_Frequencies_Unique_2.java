package com.leetcode.strings;

class Solution1647_2 {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 24; i >= 0; --i) {
            while (cnt[i] >= cnt[i + 1] && cnt[i] > 0) {
                --cnt[i];
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
        Solution1647_2 _tcSol = new Solution1647_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aab\"");
        try {
            String s = "aab";
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaabbbcc\"");
        try {
            String s = "aaabbbcc";
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"ceabaacb\"");
        try {
            String s = "ceabaacb";
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}