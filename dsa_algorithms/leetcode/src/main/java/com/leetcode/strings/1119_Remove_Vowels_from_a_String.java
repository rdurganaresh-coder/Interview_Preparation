package com.leetcode.strings;

class Solution1119 {
    public String removeVowels(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1119 _tcSol = new Solution1119();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leetcodeisacommunityforcoders\"");
        try {
            String s = "leetcodeisacommunityforcoders";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeVowels(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ltcdscmmntyfrcdrs\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aeiou\"");
        try {
            String s = "aeiou";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeVowels(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}