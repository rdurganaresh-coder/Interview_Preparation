package com.leetcode.graphs_shortest_path;

class Solution2515 {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = n;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int t = Math.abs(i - startIndex);
                ans = Math.min(ans, Math.min(t, n - t));
            }
        }
        return ans == n ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2515 _tcSol = new Solution2515();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"hello\",\"i\",\"am\",\"leetcode\",\"hello\"], target = \"hello\", startIndex = 1");
        try {
            String[] words = new String[]{"hello", "i", "am", "leetcode", "hello"};
            String target = "hello";
            int startIndex = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestTarget(words, target, startIndex)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\",\"b\",\"leetcode\"], target = \"leetcode\", startIndex = 0");
        try {
            String[] words = new String[]{"a", "b", "leetcode"};
            String target = "leetcode";
            int startIndex = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestTarget(words, target, startIndex)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"i\",\"eat\",\"leetcode\"], target = \"ate\", startIndex = 0");
        try {
            String[] words = new String[]{"i", "eat", "leetcode"};
            String target = "ate";
            int startIndex = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestTarget(words, target, startIndex)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
