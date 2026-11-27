package com.leetcode.sliding_window_two_pointers;

class Solution3090 {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        int[] cnt = new int[26];
        for (int l = 0, r = 0; r < s.length(); ++r) {
            int idx = s.charAt(r) - 'a';
            ++cnt[idx];
            while (cnt[idx] > 2) {
                --cnt[s.charAt(l++) - 'a'];
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3090 _tcSol = new Solution3090();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"bcbbbcba\"");
        try {
            String s = "bcbbbcba";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumLengthSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaaa\"");
        try {
            String s = "aaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumLengthSubstring(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}