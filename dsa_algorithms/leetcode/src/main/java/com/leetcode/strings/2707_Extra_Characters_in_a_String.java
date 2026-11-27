package com.leetcode.strings;

class Solution2707 {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> ss = new HashSet<>();
        for (String w : dictionary) {
            ss.add(w);
        }
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] + 1;
            for (int j = 0; j < i; ++j) {
                if (ss.contains(s.substring(j, i))) {
                    f[i] = Math.min(f[i], f[j]);
                }
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2707 _tcSol = new Solution2707();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leetscode\", dictionary = [\"leet\",\"code\",\"leetcode\"]");
        try {
            String s = "leetscode";
            String[] dictionary = new String[]{"leet", "code", "leetcode"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minExtraChar(s, dictionary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"sayhelloworld\", dictionary = [\"hello\",\"world\"]");
        try {
            String s = "sayhelloworld";
            String[] dictionary = new String[]{"hello", "world"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minExtraChar(s, dictionary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}