package com.leetcode.strings;

class Solution2559_2 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int n = words.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            char a = words[i].charAt(0), b = words[i].charAt(words[i].length() - 1);
            s[i + 1] = s[i] + (vowels.contains(a) && vowels.contains(b) ? 1 : 0);
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = s[r + 1] - s[l];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2559_2 _tcSol = new Solution2559_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"aba\",\"bcb\",\"ece\",\"aa\",\"e\"], queries = [[0,2],[1,4],[1,1]]");
        try {
            String[] words = new String[]{"aba", "bcb", "ece", "aa", "e"};
            int[][] queries = new int[][]{new int[]{0, 2}, new int[]{1, 4}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.vowelStrings(words, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\",\"e\",\"i\"], queries = [[0,2],[0,1],[2,2]]");
        try {
            String[] words = new String[]{"a", "e", "i"};
            int[][] queries = new int[][]{new int[]{0, 2}, new int[]{0, 1}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.vowelStrings(words, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,1]");
        System.out.println();
    }
}