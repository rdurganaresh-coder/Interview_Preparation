package com.leetcode.strings;

class ValidWordAbbr0288 {
    private Map<String, Set<String>> d = new HashMap<>();

    public ValidWordAbbr0288(String[] dictionary) {
        for (var s : dictionary) {
            d.computeIfAbsent(abbr(s), k -> new HashSet<>()).add(s);
        }
    }

    public boolean isUnique(String word) {
        var ws = d.get(abbr(word));
        return ws == null || (ws.size() == 1 && ws.contains(word));
    }

    private String abbr(String s) {
        int n = s.length();
        return n < 3 ? s : s.substring(0, 1) + (n - 2) + s.substring(n - 1);
    }
}

/**
 * Your ValidWordAbbr0288 object will be instantiated and called as such:
 * ValidWordAbbr0288 obj = new ValidWordAbbr0288(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */