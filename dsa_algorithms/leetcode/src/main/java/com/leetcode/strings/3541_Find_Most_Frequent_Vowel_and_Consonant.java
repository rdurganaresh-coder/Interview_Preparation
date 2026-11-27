package com.leetcode.strings;

class Solution3541 {
    public int maxFreqSum(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        int a = 0, b = 0;
        for (int i = 0; i < cnt.length; ++i) {
            char c = (char) (i + 'a');
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                a = Math.max(a, cnt[i]);
            } else {
                b = Math.max(b, cnt[i]);
            }
        }
        return a + b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3541 _tcSol = new Solution3541();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"successes\"");
        try {
            String s = "successes";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreqSum(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aeiaeia\"");
        try {
            String s = "aeiaeia";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreqSum(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}