package com.leetcode.strings;

class Solution3163 {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int n = word.length();
        for (int i = 0; i < n;) {
            int j = i + 1;
            while (j < n && word.charAt(j) == word.charAt(i)) {
                ++j;
            }
            int k = j - i;
            while (k > 0) {
                int x = Math.min(9, k);
                ans.append(x).append(word.charAt(i));
                k -= x;
            }
            i = j;
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3163 _tcSol = new Solution3163();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"abcde\"");
        try {
            String word = "abcde";
            System.out.println("  Output  : " + _tcShow(_tcSol.compressedString(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1a1b1c1d1e\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"aaaaaaaaaaaaaabb\"");
        try {
            String word = "aaaaaaaaaaaaaabb";
            System.out.println("  Output  : " + _tcShow(_tcSol.compressedString(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"9a5a2b\"");
        System.out.println();
    }
}