package com.leetcode.sliding_window_two_pointers;

class Solution2781 {
    public int longestValidSubstring(String word, List<String> forbidden) {
        var s = new HashSet<>(forbidden);
        int ans = 0, n = word.length();
        for (int i = 0, j = 0; j < n; ++j) {
            for (int k = j; k > Math.max(j - 10, i - 1); --k) {
                if (s.contains(word.substring(k, j + 1))) {
                    i = k + 1;
                    break;
                }
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2781 _tcSol = new Solution2781();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"cbaaaabc\", forbidden = [\"aaa\",\"cb\"]");
        try {
            String word = "cbaaaabc";
            List<String> forbidden = _tcL("aaa", "cb");
            System.out.println("  Output  : " + _tcShow(_tcSol.longestValidSubstring(word, forbidden)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"leetcode\", forbidden = [\"de\",\"le\",\"e\"]");
        try {
            String word = "leetcode";
            List<String> forbidden = _tcL("de", "le", "e");
            System.out.println("  Output  : " + _tcShow(_tcSol.longestValidSubstring(word, forbidden)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}