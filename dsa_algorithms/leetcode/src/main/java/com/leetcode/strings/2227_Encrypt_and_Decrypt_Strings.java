package com.leetcode.strings;

class Encrypter2227 {
    private Map<Character, String> mp = new HashMap<>();
    private Map<String, Integer> cnt = new HashMap<>();

    public Encrypter2227(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; ++i) {
            mp.put(keys[i], values[i]);
        }
        for (String w : dictionary) {
            cnt.merge(encrypt(w), 1, Integer::sum);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (char c : word1.toCharArray()) {
            if (!mp.containsKey(c)) {
                return "";
            }
            sb.append(mp.get(c));
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return cnt.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter2227 object will be instantiated and called as such:
 * Encrypter2227 obj = new Encrypter2227(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
