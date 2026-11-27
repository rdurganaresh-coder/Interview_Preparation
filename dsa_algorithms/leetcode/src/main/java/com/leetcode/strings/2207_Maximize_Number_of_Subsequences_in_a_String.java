package com.leetcode.strings;

class Solution2207 {
    public long maximumSubsequenceCount(String text, String pattern) {
        long ans = 0;
        int x = 0, y = 0;
        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == pattern.charAt(1)) {
                ++y;
                ans += x;
            }
            if (text.charAt(i) == pattern.charAt(0)) {
                ++x;
            }
        }
        ans += Math.max(x, y);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2207 _tcSol = new Solution2207();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \"abdcdbc\", pattern = \"ac\"");
        try {
            String text = "abdcdbc";
            String pattern = "ac";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubsequenceCount(text, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \"aabb\", pattern = \"ab\"");
        try {
            String text = "aabb";
            String pattern = "ab";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubsequenceCount(text, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
