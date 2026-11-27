package com.leetcode.strings;

class Solution1065 {
    public int[][] indexPairs(String text, String[] words) {
        Set<String> s = new HashSet<>(Arrays.asList(words));
        int n = text.length();
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (s.contains(text.substring(i, j + 1))) {
                    ans.add(new int[] {i, j});
                }
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1065 _tcSol = new Solution1065();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \"thestoryofleetcodeandme\", words = [\"story\",\"fleet\",\"leetcode\"]");
        try {
            String text = "thestoryofleetcodeandme";
            String[] words = new String[]{"story", "fleet", "leetcode"};
            System.out.println("  Output  : " + _tcShow(_tcSol.indexPairs(text, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,7],[9,13],[10,17]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \"ababa\", words = [\"aba\",\"ab\"]");
        try {
            String text = "ababa";
            String[] words = new String[]{"aba", "ab"};
            System.out.println("  Output  : " + _tcShow(_tcSol.indexPairs(text, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[0,2],[2,3],[2,4]]");
        System.out.println();
    }
}
