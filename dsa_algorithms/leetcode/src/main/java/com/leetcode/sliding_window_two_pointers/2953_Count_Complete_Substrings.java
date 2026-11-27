package com.leetcode.sliding_window_two_pointers;

class Solution2953 {
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int ans = 0;
        for (int i = 0; i < n;) {
            int j = i + 1;
            while (j < n && Math.abs(word.charAt(j) - word.charAt(j - 1)) <= 2) {
                ++j;
            }
            ans += f(word.substring(i, j), k);
            i = j;
        }
        return ans;
    }

    private int f(String s, int k) {
        int m = s.length();
        int ans = 0;
        for (int i = 1; i <= 26 && i * k <= m; ++i) {
            int l = i * k;
            int[] cnt = new int[26];
            for (int j = 0; j < l; ++j) {
                ++cnt[s.charAt(j) - 'a'];
            }
            Map<Integer, Integer> freq = new HashMap<>();
            for (int x : cnt) {
                if (x > 0) {
                    freq.merge(x, 1, Integer::sum);
                }
            }
            if (freq.getOrDefault(k, 0) == i) {
                ++ans;
            }
            for (int j = l; j < m; ++j) {
                int a = s.charAt(j) - 'a';
                int b = s.charAt(j - l) - 'a';
                freq.merge(cnt[a], -1, Integer::sum);
                ++cnt[a];
                freq.merge(cnt[a], 1, Integer::sum);

                freq.merge(cnt[b], -1, Integer::sum);
                --cnt[b];
                freq.merge(cnt[b], 1, Integer::sum);
                if (freq.getOrDefault(k, 0) == i) {
                    ++ans;
                }
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
        Solution2953 _tcSol = new Solution2953();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"igigee\", k = 2");
        try {
            String word = "igigee";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countCompleteSubstrings(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"aaabbbccc\", k = 3");
        try {
            String word = "aaabbbccc";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countCompleteSubstrings(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}