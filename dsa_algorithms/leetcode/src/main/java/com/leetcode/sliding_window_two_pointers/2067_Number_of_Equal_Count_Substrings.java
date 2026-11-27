package com.leetcode.sliding_window_two_pointers;

class Solution2067 {
    public int equalCountSubstrings(String s, int count) {
        int ans = 0;
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 1; i < 27 && i * count <= n; ++i) {
            int k = i * count;
            Arrays.fill(cnt, 0);
            int t = 0;
            for (int j = 0; j < n; ++j) {
                int a = s.charAt(j) - 'a';
                ++cnt[a];
                t += cnt[a] == count ? 1 : 0;
                t -= cnt[a] == count + 1 ? 1 : 0;
                if (j - k >= 0) {
                    int b = s.charAt(j - k) - 'a';
                    --cnt[b];
                    t += cnt[b] == count ? 1 : 0;
                    t -= cnt[b] == count - 1 ? 1 : 0;
                }
                ans += i == t ? 1 : 0;
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
        Solution2067 _tcSol = new Solution2067();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aaabcbbcc\", count = 3");
        try {
            String s = "aaabcbbcc";
            int count = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalCountSubstrings(s, count)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcd\", count = 2");
        try {
            String s = "abcd";
            int count = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalCountSubstrings(s, count)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"a\", count = 5");
        try {
            String s = "a";
            int count = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalCountSubstrings(s, count)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}