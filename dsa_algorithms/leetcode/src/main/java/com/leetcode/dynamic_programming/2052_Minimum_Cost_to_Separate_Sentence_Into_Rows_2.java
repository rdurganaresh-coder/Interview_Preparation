package com.leetcode.dynamic_programming;

class Solution2052_2 {
    public int minimumCost(String sentence, int k) {
        String[] words = sentence.split(" ");
        int n = words.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + words[i].length();
        }
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            if (s[n] - s[i] + n - i - 1 <= k) {
                continue;
            }
            int ans = Integer.MAX_VALUE;
            for (int j = i + 1; j < n && s[j] - s[i] + j - i - 1 <= k; ++j) {
                int m = s[j] - s[i] + j - i - 1;
                ans = Math.min(ans, f[j] + (k - m) * (k - m));
            }
            f[i] = ans;
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2052_2 _tcSol = new Solution2052_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence = \"i love leetcode\", k = 12");
        try {
            String sentence = "i love leetcode";
            int k = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(sentence, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "36");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence = \"a\", k = 5");
        try {
            String sentence = "a";
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(sentence, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
