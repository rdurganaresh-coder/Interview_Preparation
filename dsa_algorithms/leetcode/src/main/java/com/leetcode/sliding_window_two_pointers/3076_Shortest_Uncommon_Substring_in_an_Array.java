package com.leetcode.sliding_window_two_pointers;

class Solution3076 {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ans = new String[n];
        Arrays.fill(ans, "");
        for (int i = 0; i < n; ++i) {
            int m = arr[i].length();
            for (int j = 1; j <= m && ans[i].isEmpty(); ++j) {
                for (int l = 0; l <= m - j; ++l) {
                    String sub = arr[i].substring(l, l + j);
                    if (ans[i].isEmpty() || sub.compareTo(ans[i]) < 0) {
                        boolean ok = true;
                        for (int k = 0; k < n && ok; ++k) {
                            if (k != i && arr[k].contains(sub)) {
                                ok = false;
                            }
                        }
                        if (ok) {
                            ans[i] = sub;
                        }
                    }
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
        Solution3076 _tcSol = new Solution3076();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [\"cab\",\"ad\",\"bad\",\"c\"]");
        try {
            String[] arr = new String[]{"cab", "ad", "bad", "c"};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSubstrings(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"ab\",\"\",\"ba\",\"\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [\"abc\",\"bcd\",\"abcd\"]");
        try {
            String[] arr = new String[]{"abc", "bcd", "abcd"};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSubstrings(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"\",\"\",\"abcd\"]");
        System.out.println();
    }
}