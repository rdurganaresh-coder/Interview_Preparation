package com.leetcode.strings;

class Solution2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (var w : words) {
            int a = w.charAt(0) - 'a', b = w.charAt(1) - 'a';
            ans += cnt.getOrDefault(b << 5 | a, 0);
            cnt.merge(a << 5 | b, 1, Integer::sum);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2744 _tcSol = new Solution2744();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"cd\",\"ac\",\"dc\",\"ca\",\"zz\"]");
        try {
            String[] words = new String[]{"cd", "ac", "dc", "ca", "zz"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumNumberOfStringPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"ab\",\"ba\",\"cc\"]");
        try {
            String[] words = new String[]{"ab", "ba", "cc"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumNumberOfStringPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"aa\",\"ab\"]");
        try {
            String[] words = new String[]{"aa", "ab"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumNumberOfStringPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}