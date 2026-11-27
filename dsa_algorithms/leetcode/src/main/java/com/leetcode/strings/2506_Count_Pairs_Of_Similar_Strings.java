package com.leetcode.strings;

class Solution2506 {
    public int similarPairs(String[] words) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (var s : words) {
            int x = 0;
            for (char c : s.toCharArray()) {
                x |= 1 << (c - 'a');
            }
            ans += cnt.merge(x, 1, Integer::sum) - 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2506 _tcSol = new Solution2506();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"aba\",\"aabb\",\"abcd\",\"bac\",\"aabc\"]");
        try {
            String[] words = new String[]{"aba", "aabb", "abcd", "bac", "aabc"};
            System.out.println("  Output  : " + _tcShow(_tcSol.similarPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"aabb\",\"ab\",\"ba\"]");
        try {
            String[] words = new String[]{"aabb", "ab", "ba"};
            System.out.println("  Output  : " + _tcShow(_tcSol.similarPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"nba\",\"cba\",\"dba\"]");
        try {
            String[] words = new String[]{"nba", "cba", "dba"};
            System.out.println("  Output  : " + _tcShow(_tcSol.similarPairs(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
