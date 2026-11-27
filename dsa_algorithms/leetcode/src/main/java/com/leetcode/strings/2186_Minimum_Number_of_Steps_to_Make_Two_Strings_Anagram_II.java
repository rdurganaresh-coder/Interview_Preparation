package com.leetcode.strings;

class Solution2186 {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        for (char c : t.toCharArray()) {
            --cnt[c - 'a'];
        }
        int ans = 0;
        for (int v : cnt) {
            ans += Math.abs(v);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2186 _tcSol = new Solution2186();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leetcode\", t = \"coats\"");
        try {
            String s = "leetcode";
            String t = "coats";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSteps(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"night\", t = \"thing\"");
        try {
            String s = "night";
            String t = "thing";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSteps(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}