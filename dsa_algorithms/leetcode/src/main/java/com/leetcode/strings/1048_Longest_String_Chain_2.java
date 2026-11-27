package com.leetcode.strings;

class Solution1048_2 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> f = new HashMap<>();
        int ans = 0;
        for (String w : words) {
            int x = 1;
            for (int i = 0; i < w.length(); ++i) {
                String pred = w.substring(0, i) + w.substring(i + 1);
                x = Math.max(x, f.getOrDefault(pred, 0) + 1);
            }
            f.put(w, x);
            ans = Math.max(ans, x);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1048_2 _tcSol = new Solution1048_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"a\",\"b\",\"ba\",\"bca\",\"bda\",\"bdca\"]");
        try {
            String[] words = new String[]{"a", "b", "ba", "bca", "bda", "bdca"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestStrChain(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"xbc\",\"pcxbcf\",\"xb\",\"cxbc\",\"pcxbc\"]");
        try {
            String[] words = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestStrChain(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"abcd\",\"dbqca\"]");
        try {
            String[] words = new String[]{"abcd", "dbqca"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestStrChain(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
