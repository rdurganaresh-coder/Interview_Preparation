package com.leetcode.sliding_window_two_pointers;

class Solution1328 {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        char[] s = palindrome.toCharArray();
        int i = 0;
        while (i < n / 2 && s[i] == 'a') {
            ++i;
        }
        if (i == n / 2) {
            s[n - 1] = 'b';
        } else {
            s[i] = 'a';
        }
        return String.valueOf(s);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1328 _tcSol = new Solution1328();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "palindrome = \"abccba\"");
        try {
            String palindrome = "abccba";
            System.out.println("  Output  : " + _tcShow(_tcSol.breakPalindrome(palindrome)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaccba\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "palindrome = \"a\"");
        try {
            String palindrome = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.breakPalindrome(palindrome)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}
