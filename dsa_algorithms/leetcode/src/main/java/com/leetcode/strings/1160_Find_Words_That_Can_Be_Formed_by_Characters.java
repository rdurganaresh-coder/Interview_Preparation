package com.leetcode.strings;

class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        int[] cnt = new int[26];
        for (int i = 0; i < chars.length(); ++i) {
            ++cnt[chars.charAt(i) - 'a'];
        }
        int ans = 0;
        for (String w : words) {
            int[] wc = new int[26];
            boolean ok = true;
            for (int i = 0; i < w.length(); ++i) {
                int j = w.charAt(i) - 'a';
                if (++wc[j] > cnt[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans += w.length();
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
        Solution1160 _tcSol = new Solution1160();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"cat\",\"bt\",\"hat\",\"tree\"], chars = \"atach\"");
        try {
            String[] words = new String[]{"cat", "bt", "hat", "tree"};
            String chars = "atach";
            System.out.println("  Output  : " + _tcShow(_tcSol.countCharacters(words, chars)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"hello\",\"world\",\"leetcode\"], chars = \"welldonehoneyr\"");
        try {
            String[] words = new String[]{"hello", "world", "leetcode"};
            String chars = "welldonehoneyr";
            System.out.println("  Output  : " + _tcShow(_tcSol.countCharacters(words, chars)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}