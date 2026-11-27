package com.leetcode.backtracking;

class Solution0916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] cnt = new int[26];
        for (var b : words2) {
            int[] t = new int[26];
            for (int i = 0; i < b.length(); ++i) {
                t[b.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                cnt[i] = Math.max(cnt[i], t[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (var a : words1) {
            int[] t = new int[26];
            for (int i = 0; i < a.length(); ++i) {
                t[a.charAt(i) - 'a']++;
            }
            boolean ok = true;
            for (int i = 0; i < 26; ++i) {
                if (cnt[i] > t[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans.add(a);
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
        Solution0916 _tcSol = new Solution0916();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words1 = [\"amazon\",\"apple\",\"facebook\",\"google\",\"leetcode\"], words2 = [\"e\",\"o\"]");
        try {
            String[] words1 = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
            String[] words2 = new String[]{"e", "o"};
            System.out.println("  Output  : " + _tcShow(_tcSol.wordSubsets(words1, words2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"facebook\",\"google\",\"leetcode\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words1 = [\"amazon\",\"apple\",\"facebook\",\"google\",\"leetcode\"], words2 = [\"lc\",\"eo\"]");
        try {
            String[] words1 = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
            String[] words2 = new String[]{"lc", "eo"};
            System.out.println("  Output  : " + _tcShow(_tcSol.wordSubsets(words1, words2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"leetcode\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words1 = [\"acaac\",\"cccbb\",\"aacbb\",\"caacc\",\"bcbbb\"], words2 = [\"c\",\"cc\",\"b\"]");
        try {
            String[] words1 = new String[]{"acaac", "cccbb", "aacbb", "caacc", "bcbbb"};
            String[] words2 = new String[]{"c", "cc", "b"};
            System.out.println("  Output  : " + _tcShow(_tcSol.wordSubsets(words1, words2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"cccbb\"]");
        System.out.println();
    }
}