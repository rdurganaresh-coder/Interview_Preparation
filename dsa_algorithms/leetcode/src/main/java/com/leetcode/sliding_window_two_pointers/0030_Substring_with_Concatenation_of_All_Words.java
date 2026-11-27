package com.leetcode.sliding_window_two_pointers;

class Solution0030 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (var w : words) {
            cnt.merge(w, 1, Integer::sum);
        }
        List<Integer> ans = new ArrayList<>();
        int m = s.length(), n = words.length, k = words[0].length();
        for (int i = 0; i < k; ++i) {
            int l = i, r = i;
            Map<String, Integer> cnt1 = new HashMap<>();
            while (r + k <= m) {
                var t = s.substring(r, r + k);
                r += k;
                if (!cnt.containsKey(t)) {
                    cnt1.clear();
                    l = r;
                    continue;
                }
                cnt1.merge(t, 1, Integer::sum);
                while (cnt1.get(t) > cnt.get(t)) {
                    String w = s.substring(l, l + k);
                    if (cnt1.merge(w, -1, Integer::sum) == 0) {
                        cnt1.remove(w);
                    }
                    l += k;
                }
                if (r - l == n * k) {
                    ans.add(l);
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
        Solution0030 _tcSol = new Solution0030();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"barfoothefoobarman\", words = [\"foo\",\"bar\"]");
        try {
            String s = "barfoothefoobarman";
            String[] words = new String[]{"foo", "bar"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubstring(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,9]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"wordgoodgoodgoodbestword\", words = [\"word\",\"good\",\"best\",\"word\"]");
        try {
            String s = "wordgoodgoodgoodbestword";
            String[] words = new String[]{"word", "good", "best", "word"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubstring(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"barfoofoobarthefoobarman\", words = [\"bar\",\"foo\",\"the\"]");
        try {
            String s = "barfoofoobarthefoobarman";
            String[] words = new String[]{"bar", "foo", "the"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubstring(s, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,9,12]");
        System.out.println();
    }
}
