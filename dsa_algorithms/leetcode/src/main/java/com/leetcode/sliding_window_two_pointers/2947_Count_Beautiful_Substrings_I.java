package com.leetcode.sliding_window_two_pointers;

class Solution2947 {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int[] vs = new int[26];
        for (char c : "aeiou".toCharArray()) {
            vs[c - 'a'] = 1;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int vowels = 0;
            for (int j = i; j < n; ++j) {
                vowels += vs[s.charAt(j) - 'a'];
                int consonants = j - i + 1 - vowels;
                if (vowels == consonants && vowels * consonants % k == 0) {
                    ++ans;
                }
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
        Solution2947 _tcSol = new Solution2947();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"baeyh\", k = 2");
        try {
            String s = "baeyh";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulSubstrings(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abba\", k = 1");
        try {
            String s = "abba";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulSubstrings(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"bcdf\", k = 1");
        try {
            String s = "bcdf";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulSubstrings(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}