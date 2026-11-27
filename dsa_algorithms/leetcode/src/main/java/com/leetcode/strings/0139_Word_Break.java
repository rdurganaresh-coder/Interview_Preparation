package com.leetcode.strings;

class Solution0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (f[j] && words.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution0139 _tcSol = new Solution0139();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leetcode\", wordDict = [\"leet\",\"code\"]");
        try {
            String s = "leetcode";
            List<String> wordDict = _tcL("leet", "code");
            System.out.println("  Output  : " + _tcShow(_tcSol.wordBreak(s, wordDict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"applepenapple\", wordDict = [\"apple\",\"pen\"]");
        try {
            String s = "applepenapple";
            List<String> wordDict = _tcL("apple", "pen");
            System.out.println("  Output  : " + _tcShow(_tcSol.wordBreak(s, wordDict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"catsandog\", wordDict = [\"cats\",\"dog\",\"sand\",\"and\",\"cat\"]");
        try {
            String s = "catsandog";
            List<String> wordDict = _tcL("cats", "dog", "sand", "and", "cat");
            System.out.println("  Output  : " + _tcShow(_tcSol.wordBreak(s, wordDict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}