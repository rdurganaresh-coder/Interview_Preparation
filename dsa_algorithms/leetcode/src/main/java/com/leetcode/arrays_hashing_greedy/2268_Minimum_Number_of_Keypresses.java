package com.leetcode.arrays_hashing_greedy;

class Solution2268 {
    public int minimumKeypresses(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        Arrays.sort(cnt);
        int ans = 0, k = 1;
        for (int i = 1; i <= 26; ++i) {
            ans += k * cnt[26 - i];
            if (i % 9 == 0) {
                ++k;
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
        Solution2268 _tcSol = new Solution2268();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"apple\"");
        try {
            String s = "apple";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumKeypresses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcdefghijkl\"");
        try {
            String s = "abcdefghijkl";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumKeypresses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}