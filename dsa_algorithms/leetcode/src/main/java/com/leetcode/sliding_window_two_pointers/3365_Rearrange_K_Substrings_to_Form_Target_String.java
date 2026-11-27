package com.leetcode.sliding_window_two_pointers;

class Solution3365 {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        Map<String, Integer> cnt = new HashMap<>(k);
        int n = s.length();
        int m = n / k;
        for (int i = 0; i < n; i += m) {
            cnt.merge(s.substring(i, i + m), 1, Integer::sum);
            cnt.merge(t.substring(i, i + m), -1, Integer::sum);
        }
        for (int v : cnt.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3365 _tcSol = new Solution3365();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcd\", t = \"cdab\", k = 2");
        try {
            String s = "abcd";
            String t = "cdab";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossibleToRearrange(s, t, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aabbcc\", t = \"bbaacc\", k = 3");
        try {
            String s = "aabbcc";
            String t = "bbaacc";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossibleToRearrange(s, t, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"aabbcc\", t = \"bbaacc\", k = 2");
        try {
            String s = "aabbcc";
            String t = "bbaacc";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossibleToRearrange(s, t, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
