package com.leetcode.strings;

class Solution2516 {
    public int takeCharacters(String s, int k) {
        int[] cnt = new int[3];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        for (int x : cnt) {
            if (x < k) {
                return -1;
            }
        }
        int mx = 0, j = 0;
        for (int i = 0; i < n; ++i) {
            int c = s.charAt(i) - 'a';
            --cnt[c];
            while (cnt[c] < k) {
                ++cnt[s.charAt(j++) - 'a'];
            }
            mx = Math.max(mx, i - j + 1);
        }
        return n - mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2516 _tcSol = new Solution2516();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aabaaaacaabc\", k = 2");
        try {
            String s = "aabaaaacaabc";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.takeCharacters(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"a\", k = 1");
        try {
            String s = "a";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.takeCharacters(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}