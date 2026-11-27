package com.leetcode.dynamic_programming;

class Solution2901 {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        int[] f = new int[n];
        int[] g = new int[n];
        Arrays.fill(f, 1);
        Arrays.fill(g, -1);
        int mx = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (groups[i] != groups[j] && f[i] < f[j] + 1 && check(words[i], words[j])) {
                    f[i] = f[j] + 1;
                    g[i] = j;
                    mx = Math.max(mx, f[i]);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (f[i] == mx) {
                for (int j = i; j >= 0; j = g[j]) {
                    ans.add(words[j]);
                }
                break;
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    private boolean check(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                ++cnt;
            }
        }
        return cnt == 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2901 _tcSol = new Solution2901();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"bab\",\"dab\",\"cab\"], groups = [1,2,2]");
        try {
            String[] words = new String[]{"bab", "dab", "cab"};
            int[] groups = new int[]{1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.getWordsInLongestSubsequence(words, groups)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"bab\",\"cab\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\",\"b\",\"c\",\"d\"], groups = [1,2,3,4]");
        try {
            String[] words = new String[]{"a", "b", "c", "d"};
            int[] groups = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.getWordsInLongestSubsequence(words, groups)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\",\"b\",\"c\",\"d\"]");
        System.out.println();
    }
}