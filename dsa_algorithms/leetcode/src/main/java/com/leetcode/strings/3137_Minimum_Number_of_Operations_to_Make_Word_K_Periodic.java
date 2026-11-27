package com.leetcode.strings;

class Solution3137 {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        int n = word.length();
        int mx = 0;
        for (int i = 0; i < n; i += k) {
            mx = Math.max(mx, cnt.merge(word.substring(i, i + k), 1, Integer::sum));
        }
        return n / k - mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3137 _tcSol = new Solution3137();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"leetcodeleet\", k = 4");
        try {
            String word = "leetcodeleet";
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperationsToMakeKPeriodic(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"leetcoleet\", k = 2");
        try {
            String word = "leetcoleet";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperationsToMakeKPeriodic(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}