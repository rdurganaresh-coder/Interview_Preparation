package com.leetcode.sliding_window_two_pointers;

class Solution3329 {
    public long numberOfSubstrings(String s, int k) {
        int[] cnt = new int[26];
        long ans = 0;
        for (int l = 0, r = 0; r < s.length(); ++r) {
            int c = s.charAt(r) - 'a';
            ++cnt[c];
            while (cnt[c] >= k) {
                --cnt[s.charAt(l) - 'a'];
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
        Solution3329 _tcSol = new Solution3329();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abacb\", k = 2");
        try {
            String s = "abacb";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubstrings(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcde\", k = 1");
        try {
            String s = "abcde";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubstrings(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}
