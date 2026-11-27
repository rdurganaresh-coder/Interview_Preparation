package com.leetcode.dynamic_programming;

class Solution2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                ans.add(words[i]);
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
        Solution2900 _tcSol = new Solution2900();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"e\",\"a\",\"b\"], groups = [0,0,1]");
        try {
            String[] words = new String[]{"e", "a", "b"};
            int[] groups = new int[]{0, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.getLongestSubsequence(words, groups)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"e\",\"b\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\",\"b\",\"c\",\"d\"], groups = [1,0,1,1]");
        try {
            String[] words = new String[]{"a", "b", "c", "d"};
            int[] groups = new int[]{1, 0, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.getLongestSubsequence(words, groups)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\",\"b\",\"c\"]");
        System.out.println();
    }
}