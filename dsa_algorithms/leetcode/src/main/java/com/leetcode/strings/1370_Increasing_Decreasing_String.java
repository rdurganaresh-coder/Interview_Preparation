package com.leetcode.strings;

class Solution1370 {
    public String sortString(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            for (int i = 0; i < 26; ++i) {
                if (cnt[i] > 0) {
                    sb.append((char) ('a' + i));
                    --cnt[i];
                }
            }
            for (int i = 25; i >= 0; --i) {
                if (cnt[i] > 0) {
                    sb.append((char) ('a' + i));
                    --cnt[i];
                }
            }
        }
        return sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1370 _tcSol = new Solution1370();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aaaabbbbcccc\"");
        try {
            String s = "aaaabbbbcccc";
            System.out.println("  Output  : " + _tcShow(_tcSol.sortString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abccbaabccba\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"rat\"");
        try {
            String s = "rat";
            System.out.println("  Output  : " + _tcShow(_tcSol.sortString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"art\"");
        System.out.println();
    }
}