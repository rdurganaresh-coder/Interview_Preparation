package com.leetcode.strings;

class Solution3016 {
    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); ++i) {
            ++cnt[word.charAt(i) - 'a'];
        }
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans += (i / 8 + 1) * cnt[26 - i - 1];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3016 _tcSol = new Solution3016();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"abcde\"");
        try {
            String word = "abcde";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPushes(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"xyzxyzxyzxyz\"");
        try {
            String word = "xyzxyzxyzxyz";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPushes(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"aabbccddeeffgghhiiiiii\"");
        try {
            String word = "aabbccddeeffgghhiiiiii";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPushes(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();
    }
}