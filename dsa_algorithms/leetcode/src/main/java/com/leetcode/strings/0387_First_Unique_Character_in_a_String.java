package com.leetcode.strings;

class Solution0387 {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < n; ++i) {
            if (cnt[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0387 _tcSol = new Solution0387();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leetcode\"");
        try {
            String s = "leetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.firstUniqChar(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"loveleetcode\"");
        try {
            String s = "loveleetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.firstUniqChar(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"aabb\"");
        try {
            String s = "aabb";
            System.out.println("  Output  : " + _tcShow(_tcSol.firstUniqChar(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}