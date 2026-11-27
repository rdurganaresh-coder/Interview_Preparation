package com.leetcode.strings;

class Solution0438 {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> ans = new ArrayList<>();
        if (m < n) {
            return ans;
        }
        int[] cnt1 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[p.charAt(i) - 'a'];
        }
        int[] cnt2 = new int[26];
        for (int i = 0; i < n - 1; ++i) {
            ++cnt2[s.charAt(i) - 'a'];
        }
        for (int i = n - 1; i < m; ++i) {
            ++cnt2[s.charAt(i) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                ans.add(i - n + 1);
            }
            --cnt2[s.charAt(i - n + 1) - 'a'];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0438 _tcSol = new Solution0438();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"cbaebabacd\", p = \"abc\"");
        try {
            String s = "cbaebabacd";
            String p = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.findAnagrams(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abab\", p = \"ab\"");
        try {
            String s = "abab";
            String p = "ab";
            System.out.println("  Output  : " + _tcShow(_tcSol.findAnagrams(s, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2]");
        System.out.println();
    }
}