package com.leetcode.strings;

class WordDistance0244 {
    private Map<String, List<Integer>> d = new HashMap<>();

    public WordDistance0244(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; ++i) {
            d.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> a = d.get(word1), b = d.get(word2);
        int ans = 0x3f3f3f3f;
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            ans = Math.min(ans, Math.abs(a.get(i) - b.get(j)));
            if (a.get(i) <= b.get(j)) {
                ++i;
            } else {
                ++j;
            }
        }
        return ans;
    }
}

/**
 * Your WordDistance0244 object will be instantiated and called as such:
 * WordDistance0244 obj = new WordDistance0244(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */