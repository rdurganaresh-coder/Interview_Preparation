package com.leetcode.strings;

class Solution0028_2 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        final int mod = (1 << 31) - 1;
        long target = 0, sha = 0, multi = 1;
        for (int i = 0; i < m; ++i) {
            target = (target * 256 + needle.charAt(i)) % mod;
        }
        for (int i = 1; i < m; ++i) {
            multi = multi * 256 % mod;
        }
        int left = 0;
        for (int right = 0; right < n; ++right) {
            sha = (sha * 256 + haystack.charAt(right)) % mod;
            if (right - left + 1 < m) {
                continue;
            }
            if (sha == target && haystack.substring(left, right + 1).equals(needle)) {
                return left;
            }
            sha = (sha - haystack.charAt(left) * multi % mod + mod) % mod;
            ++left;
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0028_2 _tcSol = new Solution0028_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "haystack = \"sadbutsad\", needle = \"sad\"");
        try {
            String haystack = "sadbutsad";
            String needle = "sad";
            System.out.println("  Output  : " + _tcShow(_tcSol.strStr(haystack, needle)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "haystack = \"leetcode\", needle = \"leeto\"");
        try {
            String haystack = "leetcode";
            String needle = "leeto";
            System.out.println("  Output  : " + _tcShow(_tcSol.strStr(haystack, needle)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
