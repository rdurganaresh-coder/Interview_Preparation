package com.leetcode.sliding_window_two_pointers;

class Solution1371 {
    public int findTheLongestSubstring(String s) {
        String vowels = "aeiou";
        int[] d = new int[32];
        Arrays.fill(d, 1 << 29);
        d[0] = 0;
        int ans = 0, mask = 0;
        for (int i = 1; i <= s.length(); ++i) {
            char c = s.charAt(i - 1);
            for (int j = 0; j < 5; ++j) {
                if (c == vowels.charAt(j)) {
                    mask ^= 1 << j;
                    break;
                }
            }
            ans = Math.max(ans, i - d[mask]);
            d[mask] = Math.min(d[mask], i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1371 _tcSol = new Solution1371();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"eleetminicoworoep\"");
        try {
            String s = "eleetminicoworoep";
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheLongestSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"leetcodeisgreat\"");
        try {
            String s = "leetcodeisgreat";
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheLongestSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"bcbcbc\"");
        try {
            String s = "bcbcbc";
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheLongestSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
