package com.leetcode.sliding_window_two_pointers;

class Solution1915 {
    public long wonderfulSubstrings(String word) {
        int[] cnt = new int[1 << 10];
        cnt[0] = 1;
        long ans = 0;
        int st = 0;
        for (char c : word.toCharArray()) {
            st ^= 1 << (c - 'a');
            ans += cnt[st];
            for (int i = 0; i < 10; ++i) {
                ans += cnt[st ^ (1 << i)];
            }
            ++cnt[st];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1915 _tcSol = new Solution1915();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"aba\"");
        try {
            String word = "aba";
            System.out.println("  Output  : " + _tcShow(_tcSol.wonderfulSubstrings(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"aabb\"");
        try {
            String word = "aabb";
            System.out.println("  Output  : " + _tcShow(_tcSol.wonderfulSubstrings(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"he\"");
        try {
            String word = "he";
            System.out.println("  Output  : " + _tcShow(_tcSol.wonderfulSubstrings(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}