package com.leetcode.strings;

class Solution0245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int ans = wordsDict.length;
        if (word1.equals(word2)) {
            for (int i = 0, j = -1; i < wordsDict.length; ++i) {
                if (wordsDict[i].equals(word1)) {
                    if (j != -1) {
                        ans = Math.min(ans, i - j);
                    }
                    j = i;
                }
            }
        } else {
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
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0245 _tcSol = new Solution0245();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "wordsDict = [\"practice\", \"makes\", \"perfect\", \"coding\", \"makes\"], word1 = \"makes\", word2 = \"coding\"");
        try {
            String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
            String word1 = "makes";
            String word2 = "coding";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestWordDistance(wordsDict, word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "wordsDict = [\"practice\", \"makes\", \"perfect\", \"coding\", \"makes\"], word1 = \"makes\", word2 = \"makes\"");
        try {
            String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
            String word1 = "makes";
            String word2 = "makes";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestWordDistance(wordsDict, word1, word2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}