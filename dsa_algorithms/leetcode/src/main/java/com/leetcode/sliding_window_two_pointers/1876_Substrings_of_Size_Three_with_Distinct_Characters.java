package com.leetcode.sliding_window_two_pointers;

class Solution1876 {
    public int countGoodSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for (int l = 0, r = 0, mask = 0; r < n; ++r) {
            int x = s.charAt(r) - 'a';
            while ((mask >> x & 1) == 1) {
                int y = s.charAt(l++) - 'a';
                mask ^= 1 << y;
            }
            mask |= 1 << x;
            ans += r - l + 1 >= 3 ? 1 : 0;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1876 _tcSol = new Solution1876();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"xyzzaz\"");
        try {
            String s = "xyzzaz";
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodSubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aababcabc\"");
        try {
            String s = "aababcabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodSubstrings(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
