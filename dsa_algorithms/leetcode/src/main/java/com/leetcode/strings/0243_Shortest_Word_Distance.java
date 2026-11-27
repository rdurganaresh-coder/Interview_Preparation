package com.leetcode.strings;

class Solution0243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int ans = 0x3f3f3f3f;
        for (int k = 0, i = -1, j = -1; k < wordsDict.length; ++k) {
            if (wordsDict[k].equals(word1)) {
                i = k;
            }
            if (wordsDict[k].equals(word2)) {
                j = k;
            }
            if (i != -1 && j != -1) {
                ans = Math.min(ans, Math.abs(i - j));
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
        Solution0243 _tcSol = new Solution0243();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "wordsDict = [\"practice\", \"makes\", \"perfect\", \"coding\", \"makes\"], word1 = \"coding\", word2 = \"practice\"");
        try {
            String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
            String word1 = "coding";
            String word2 = "practice";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistance(wordsDict, word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "wordsDict = [\"practice\", \"makes\", \"perfect\", \"coding\", \"makes\"], word1 = \"makes\", word2 = \"coding\"");
        try {
            String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
            String word1 = "makes";
            String word2 = "coding";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestDistance(wordsDict, word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}