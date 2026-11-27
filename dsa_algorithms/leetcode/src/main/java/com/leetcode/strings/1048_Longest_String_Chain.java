package com.leetcode.strings;

class Solution1048 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] f = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (check(words[j], words[i])) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    private boolean check(String a, String b) {
        if (a.length() + 1 != b.length()) {
            return false;
        }
        int i = 0;
        for (int j = 0; j < b.length(); ++j) {
            if (i < a.length() && a.charAt(i) == b.charAt(j)) {
                ++i;
            }
        }
        return i == a.length();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1048 _tcSol = new Solution1048();
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
