package com.leetcode.strings;

class WordFilter0745 {
    private Map<String, Integer> d = new HashMap<>();

    public WordFilter0745(String[] words) {
        for (int k = 0; k < words.length; ++k) {
            String w = words[k];
            int n = w.length();
            for (int i = 0; i <= n; ++i) {
                String a = w.substring(0, i);
                for (int j = 0; j <= n; ++j) {
                    String b = w.substring(j);
                    d.put(a + "." + b, k);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return d.getOrDefault(pref + "." + suff, -1);
    }
}

/**
 * Your WordFilter0745 object will be instantiated and called as such:
 * WordFilter0745 obj = new WordFilter0745(words);
 * int param_1 = obj.f(pref,suff);
 */