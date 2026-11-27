package com.leetcode.arrays_hashing_greedy;

class Solution2325 {
    public String decodeMessage(String key, String message) {
        char[] d = new char[128];
        d[' '] = ' ';
        for (int i = 0, j = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (d[c] == 0) {
                d[c] = (char) ('a' + j++);
            }
        }
        char[] ans = message.toCharArray();
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = d[ans[i]];
        }
        return String.valueOf(ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2325 _tcSol = new Solution2325();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "key = \"the quick brown fox jumps over the lazy dog\", message = \"vkbs bs t suepuv\"");
        try {
            String key = "the quick brown fox jumps over the lazy dog";
            String message = "vkbs bs t suepuv";
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeMessage(key, message)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"this is a secret\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "key = \"eljuxhpwnyrdgtqkviszcfmabo\", message = \"zwx hnfx lqantp mnoeius ycgk vcnjrdb\"");
        try {
            String key = "eljuxhpwnyrdgtqkviszcfmabo";
            String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeMessage(key, message)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"the five boxing wizards jump quickly\"");
        System.out.println();
    }
}