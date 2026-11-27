package com.leetcode.strings;

class Solution0966 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> s = new HashSet<>();
        Map<String, String> low = new HashMap<>();
        Map<String, String> pat = new HashMap<>();
        for (String w : wordlist) {
            s.add(w);
            String t = w.toLowerCase();
            low.putIfAbsent(t, w);
            pat.putIfAbsent(f(t), w);
        }
        int m = queries.length;
        String[] ans = new String[m];
        for (int i = 0; i < m; ++i) {
            String q = queries[i];
            if (s.contains(q)) {
                ans[i] = q;
                continue;
            }
            q = q.toLowerCase();
            if (low.containsKey(q)) {
                ans[i] = low.get(q);
                continue;
            }
            q = f(q);
            if (pat.containsKey(q)) {
                ans[i] = pat.get(q);
                continue;
            }
            ans[i] = "";
        }
        return ans;
    }

    private String f(String w) {
        char[] cs = w.toCharArray();
        for (int i = 0; i < cs.length; ++i) {
            char c = cs[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cs[i] = '*';
            }
        }
        return String.valueOf(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0966 _tcSol = new Solution0966();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "wordlist = [\"KiTe\",\"kite\",\"hare\",\"Hare\"], queries = [\"kite\",\"Kite\",\"KiTe\",\"Hare\",\"HARE\",\"Hear\",\"hear\",\"keti\",\"keet\",\"keto\"]");
        try {
            String[] wordlist = new String[]{"KiTe", "kite", "hare", "Hare"};
            String[] queries = new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
            System.out.println("  Output  : " + _tcShow(_tcSol.spellchecker(wordlist, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"kite\",\"KiTe\",\"KiTe\",\"Hare\",\"hare\",\"\",\"\",\"KiTe\",\"\",\"KiTe\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "wordlist = [\"yellow\"], queries = [\"YellOw\"]");
        try {
            String[] wordlist = new String[]{"yellow"};
            String[] queries = new String[]{"YellOw"};
            System.out.println("  Output  : " + _tcShow(_tcSol.spellchecker(wordlist, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"yellow\"]");
        System.out.println();
    }
}