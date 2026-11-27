package com.leetcode.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution0819 {
    private static Pattern pattern = Pattern.compile("[a-z]+");

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned) {
            bannedWords.add(word);
        }
        Map<String, Integer> counter = new HashMap<>();
        Matcher matcher = pattern.matcher(paragraph.toLowerCase());
        while (matcher.find()) {
            String word = matcher.group();
            if (bannedWords.contains(word)) {
                continue;
            }
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        String ans = null;
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
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
        Solution0819 _tcSol = new Solution0819();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "paragraph = \"Bob hit a ball, the hit BALL flew far after it was hit.\", banned = [\"hit\"]");
        try {
            String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
            String[] banned = new String[]{"hit"};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostCommonWord(paragraph, banned)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ball\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "paragraph = \"a.\", banned = []");
        try {
            String paragraph = "a.";
            String[] banned = new String[]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostCommonWord(paragraph, banned)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a\"");
        System.out.println();
    }
}