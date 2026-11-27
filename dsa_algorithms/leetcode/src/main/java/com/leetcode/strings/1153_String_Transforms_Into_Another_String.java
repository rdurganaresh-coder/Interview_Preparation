package com.leetcode.strings;

class Solution1153 {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        int m = 0;
        int[] cnt = new int[26];
        int n = str1.length();
        for (int i = 0; i < n; ++i) {
            if (++cnt[str2.charAt(i) - 'a'] == 1) {
                ++m;
            }
        }
        if (m == 26) {
            return false;
        }
        int[] d = new int[26];
        for (int i = 0; i < n; ++i) {
            int a = str1.charAt(i) - 'a';
            int b = str2.charAt(i) - 'a';
            if (d[a] == 0) {
                d[a] = b + 1;
            } else if (d[a] != b + 1) {
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
        Solution1153 _tcSol = new Solution1153();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "str1 = \"aabcc\", str2 = \"ccdee\"");
        try {
            String str1 = "aabcc";
            String str2 = "ccdee";
            System.out.println("  Output  : " + _tcShow(_tcSol.canConvert(str1, str2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "str1 = \"leetcode\", str2 = \"codeleet\"");
        try {
            String str1 = "leetcode";
            String str2 = "codeleet";
            System.out.println("  Output  : " + _tcShow(_tcSol.canConvert(str1, str2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}