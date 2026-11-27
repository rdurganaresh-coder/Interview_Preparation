package com.leetcode.sliding_window_two_pointers;

class Solution1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length() - minSize + 1; ++i) {
            String t = s.substring(i, i + minSize);
            Set<Character> ss = new HashSet<>();
            for (int j = 0; j < minSize; ++j) {
                ss.add(t.charAt(j));
            }
            if (ss.size() <= maxLetters) {
                cnt.merge(t, 1, Integer::sum);
                ans = Math.max(ans, cnt.get(t));
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
        Solution1297 _tcSol = new Solution1297();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aababcaab\", maxLetters = 2, minSize = 3, maxSize = 4");
        try {
            String s = "aababcaab";
            int maxLetters = 2;
            int minSize = 3;
            int maxSize = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreq(s, maxLetters, minSize, maxSize)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaaa\", maxLetters = 1, minSize = 3, maxSize = 3");
        try {
            String s = "aaaa";
            int maxLetters = 1;
            int minSize = 3;
            int maxSize = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreq(s, maxLetters, minSize, maxSize)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
